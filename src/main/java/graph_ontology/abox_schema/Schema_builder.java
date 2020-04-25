package graph_ontology.abox_schema;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;

import java.io.*;

public class Schema_builder {

    public static void build_affiliation() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.AFFILIATION_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String affiliationURI = row_data[0];
            String aName = row_data[1];
            String affiliationType = row_data[2];

            String affiliationName = aName.replace(" ", "_");


            if (affiliationType.equals("University")) {
                Resource currentAffiliation = model.createResource(Data_config.DBPEDIA_URL + "University/" + affiliationURI)
                        .addProperty(model.createProperty(Data_config.DBPEDIA_URL + "affiliation_name"), affiliationName);
            } else if (affiliationType.equals("Company")) {
                Resource currentAffiliation = model.createResource(Data_config.DBPEDIA_URL + "Company/" + affiliationURI)
                        .addProperty(model.createProperty(Data_config.DBPEDIA_URL + "affiliation_name"), affiliationName);
            }

        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "affiliation.nt")), true), "NT");
    }

    public static void build_author() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.AUTHOR_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String authorURI = row_data[0];
            String aName = row_data[1];

            String authorName = aName.replace(" ", "_");

            Resource currentAuthor = model.createResource(Data_config.BASE_URL + authorURI)
                    .addProperty(model.createProperty(Data_config.BASE_URL + "author_name"), authorName);
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "author.nt")), true), "NT");
    }

    public static void build_review() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.REVIEW_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String reviewURI = row_data[0];
            String content = row_data[1];
            String reviewDecision = row_data[2];

            String reviewContent = content.replace(" ", "_");

            Resource currentReview = model.createResource(Data_config.BASE_URL + reviewURI)
                    .addProperty(model.createProperty(Data_config.BASE_URL + "review_content"), reviewContent)
                    .addProperty(model.createProperty(Data_config.BASE_URL + "review_decision"), reviewDecision);
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "review.nt")), true), "NT");
    }

    public static void build_article() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.ARTICLE_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(",");

            String articleURI = row_data[0];
            String aDate = row_data[1];
            String articleNumber = row_data[2];
            String aPages = row_data[3];
            String aTitle = row_data[4];

            String articleDate = aDate.replace("-", "_");
            String articlePages = aPages.replace("-", "_");
            String articleTitle = aTitle.replace(" ", "_");

            Resource currentArticle = model.createResource(Data_config.RESOURCE_URL + articleURI)
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "mdate"), articleDate);

            if (!(articleTitle.equals("NaN"))) {
                currentArticle.addProperty(model.createProperty(Data_config.PROPERTY_URL + "title"), articleTitle);
            }

            if (!(articleNumber.equals("NaN"))) {
                currentArticle.addProperty(model.createProperty(Data_config.PROPERTY_URL + "number"), articleNumber);
            }

            if (!(articlePages.equals("NaN"))) {
                currentArticle.addProperty(model.createProperty(Data_config.PROPERTY_URL + "pages"), articlePages);
            }
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "article.nt")), true), "NT");
    }

    public static void build_journal() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.JOURNAL_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String journalURI = row_data[0];
            String jName = row_data[1];

            String journalName = jName.replaceAll("[^a-zA-Z0-9]", "_");

            Resource currentJournal = model.createResource(Data_config.RESOURCE_URL + journalURI)
                    .addProperty(FOAF.name, journalName);
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "journal.nt")), true), "NT");
    }

    public static void build_conference() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.CONFERENCE_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String conferenceURI = row_data[0];
            String cName = row_data[1];

            String conferenceName = cName.replaceAll("[ -]", "_");

            Resource currentJournal = model.createResource(Data_config.RESOURCE_URL + conferenceURI)
                    .addProperty(FOAF.name, conferenceName);
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "conference.nt")), true), "NT");
    }

    public static void build_keyword() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.KEYWORD_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String keywordURI = row_data[0];
            String kName = row_data[1];

            String keywordName = kName.replace(" ", "_");

            Resource currentJournal = model.createResource(Data_config.BASE_URL + keywordURI)
                    .addProperty(model.createProperty(Data_config.BASE_URL + "keyword_name"), keywordName);
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "keyword.nt")), true), "NT");
    }

    public static void build_belongs_to_affiliation() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.BELONGS_TO_AFFILIATION_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String authorURI = row_data[0];
            String affiliationURI = row_data[1];

            String relationshipURI = authorURI + "_" + affiliationURI;

            Resource currentRelationship = model.createResource(Data_config.BASE_URL + relationshipURI)
                    .addProperty(model.createProperty(Data_config.BASE_URL + "author"), model.createResource(authorURI))
                    .addProperty(model.createProperty(Data_config.BASE_URL + "affiliation"), model.createResource(affiliationURI));
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "belongs_to_affiliation.nt")), true), "NT");
    }

    public static void build_makes_review() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.MAKES_REVIEW_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String authorURI = row_data[0];
            String reviewURI = row_data[1];

            String relationshipURI = authorURI + "_" + reviewURI;

            Resource currentRelationship = model.createResource(Data_config.BASE_URL + relationshipURI)
                    .addProperty(model.createProperty(Data_config.BASE_URL + "author"), model.createResource(authorURI))
                    .addProperty(model.createProperty(Data_config.BASE_URL + "review"), model.createResource(reviewURI));
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "makes_review.nt")), true), "NT");
    }

    public static void build_about_article() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.ABOUT_ARTICLE_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String reviewURI = row_data[0];
            String articleURI = row_data[1];

            String relationshipURI = reviewURI + "_" + articleURI;

            Resource currentRelationship = model.createResource(Data_config.BASE_URL + relationshipURI)
                    .addProperty(model.createProperty(Data_config.BASE_URL + "review"), model.createResource(reviewURI))
                    .addProperty(model.createProperty(Data_config.BASE_URL + "article"), model.createResource(articleURI));
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "about_article.nt")), true), "NT");
    }

    public static void build_cites_article() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.CITES_ARTICLE_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String articleURI = row_data[0];
            String citedArticleURI = row_data[1];

            String relationshipURI = articleURI + "_" + citedArticleURI;

            Resource currentRelationship = model.createResource(Data_config.RESOURCE_URL + relationshipURI)
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "article"), model.createResource(articleURI))
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "cited_article"), model.createResource(citedArticleURI));
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "cites_article.nt")), true), "NT");
    }

    public static void build_written_by_author() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.WRITTEN_BY_AUTHOR_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String articleURI = row_data[0];
            String authorURI = row_data[1];
            String corresponding = row_data[2];

            String relationshipURI = articleURI + "_" + authorURI;

            Resource currentRelationship = model.createResource(Data_config.RESOURCE_URL + relationshipURI)
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "article"), model.createResource(articleURI))
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "author"), model.createResource(authorURI))
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "corresponding"), corresponding);
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "written_by_author.nt")), true), "NT");
    }

    public static void build_presented_in_conference() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.PRESENTED_IN_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String articleURI = row_data[0];
            String conferenceURI = row_data[1];
            String venueName = row_data[2];
            String periodData = row_data[3];
            String edition = row_data[4];

            String venue = venueName.replace(" ", "_");
            String period = periodData.replace(" ", "_");

            String relationshipURI = articleURI + "_" + conferenceURI;

            Resource currentRelationship = model.createResource(Data_config.RESOURCE_URL + relationshipURI)
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "article"), model.createResource(articleURI))
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "conference"), model.createResource(conferenceURI))
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "venue"), venue)
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "period"), period)
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "edition"), edition);
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "presented_in_conference.nt")), true), "NT");
    }

    public static void build_published_in_journal() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.PUBLISHED_IN_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(",");

            String articleURI = row_data[0];
            String journalURI = row_data[1];
            String volumeName = row_data[2];
            String year = row_data[3];
            String number = row_data[4];

            String volume = volumeName.replace("-", "_");

            String relationshipURI = articleURI + "_" + journalURI;

            Resource currentRelationship = model.createResource(Data_config.RESOURCE_URL + relationshipURI)
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "article"), model.createResource(articleURI))
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "journal"), model.createResource(journalURI))
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "year"), year);

            if (!(number.equals("NaN"))) {
                currentRelationship.addProperty(model.createProperty(Data_config.PROPERTY_URL + "number"), number);
            }

            if (!(volume.equals("NaN"))) {
                currentRelationship.addProperty(model.createProperty(Data_config.PROPERTY_URL + "volume"), volume);
            }
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "published_in_journal.nt")), true), "NT");
    }

    public static void build_has_keyword() throws IOException {
        Model model = ModelFactory.createDefaultModel();

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.HAS_KEYWORD_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String articleURI = row_data[0];
            String keywordURI = row_data[1];

            String relationshipURI = articleURI + "_" + keywordURI;

            Resource currentRelationship = model.createResource(Data_config.RESOURCE_URL + relationshipURI)
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "article"), model.createResource(articleURI))
                    .addProperty(model.createProperty(Data_config.PROPERTY_URL + "keyword"), model.createResource(keywordURI));
        }
        csvReader.close();

        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "has_keyword.nt")), true), "NT");
    }
}

