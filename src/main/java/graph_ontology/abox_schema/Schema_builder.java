package graph_ontology.abox_schema;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.io.*;

public class Schema_builder {

    public static void build_affiliation(Model model) throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.AFFILIATION_PATH));
        String row;

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource companyResource = model.getResource(Data_config.COMPANY_BASE_URL);
        Resource universityResource = model.getResource(Data_config.UNIVERSITY_BASE_URL);
        Property companyName = model.getProperty(Data_config.COMPANY_NAME_PROPERTY_URL);
        Property universityName = model.getProperty(Data_config.UNIVERSITY_NAME_PROPERTY_URL);

        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String affiliationURI = row_data[0];
            String aName = row_data[1];
            String affiliationType = row_data[2];

            String affiliationName = aName.replace(" ", "_");

            if (affiliationType.equals("University")) {
                Resource currentAffiliation = model.createResource(Data_config.BASE_URL + "/resource/" + affiliationURI)
                        .addLiteral(universityName, affiliationName);
                model.add(model.createStatement(currentAffiliation, rdfType, universityResource));
            } else if (affiliationType.equals("Company")) {
                Resource currentAffiliation = model.createResource(Data_config.BASE_URL + "/resource/" + affiliationURI)
                        .addLiteral(companyName, affiliationName);
                model.add(model.createStatement(currentAffiliation, rdfType, companyResource));
            }
        }
        csvReader.close();
    }

    public static void build_author(Model model) throws IOException {

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource authorResource = model.getResource(Data_config.AUTHOR_BASE_URL);
        Property authorNameProp = model.getProperty(Data_config.AUTHOR_NAME_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.AUTHOR_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String authorURI = row_data[0];
            String aName = row_data[1];

            String authorName = aName.replace(" ", "_");

            Resource currentAuthor = model.createResource(Data_config.BASE_URL + authorURI)
                    .addLiteral(authorNameProp, authorName);
            model.add(model.createStatement(currentAuthor, rdfType, authorResource));
        }
        csvReader.close();
    }

    public static void build_review(Model model) throws IOException {

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource reviewResource = model.getResource(Data_config.REVIEW_BASE_URL);
        Property reviewContentProp = model.getProperty(Data_config.REVIEW_CONTENT_PROPERTY_URL);
        Property reviewDecisionProp = model.getProperty(Data_config.REVIEW_DECISION_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.REVIEW_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String reviewURI = row_data[0];
            String content = row_data[1];
            String reviewDecision = row_data[2];

            String reviewContent = content.replace(" ", "_");

            Resource currentReview = model.createResource(Data_config.BASE_URL + reviewURI)
                    .addLiteral(reviewDecisionProp, reviewDecision)
                    .addLiteral(reviewContentProp, reviewContent);
            model.add(model.createStatement(currentReview, rdfType, reviewResource));
        }
        csvReader.close();
    }

    public static void build_article(Model model) throws IOException {

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource articleResource = model.getResource(Data_config.ARTICLE_BASE_URL);
        Property articleLastPublDateProp = model.getProperty(Data_config.ARTICLE_PUBLICATIONDATE_PROPERTY_URL);
        Property articleTitlteProp = model.getProperty(Data_config.ARTICLE_TITLE_PROPERTY_URL);
        Property articlePagesProp = model.getProperty(Data_config.ARTICLE_PAGES_PROPERTY_URL);
        Property articleNumberProp = model.getProperty(Data_config.ARTICLE_NUMBER_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.ARTICLE_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(",");

            // Read the DataProperties
            String articleURI = row_data[0];
            String lastPublicationDate = row_data[1];
            String articleNumber = row_data[2];
            String articlePages = row_data[3];
            String articleTitle = row_data[4];

            // Generate the Model for the ABOX triples
            Resource currentArticle = model.createResource(Data_config.DBPEDIA_INSTANCE_URL + articleURI)
                    .addLiteral(articleLastPublDateProp, lastPublicationDate);

            if (!(articleTitle.equals("NaN"))) {
                currentArticle.addLiteral(articleTitlteProp, articleTitle);
            }

            if (!(articleNumber.equals("NaN"))) {
                currentArticle.addLiteral(articleNumberProp, articleNumber);
            }

            if (!(articlePages.equals("NaN"))) {
                currentArticle.addLiteral(articlePagesProp, articlePages);
            }
            model.add(model.createStatement(currentArticle, rdfType, articleResource));
        }
        csvReader.close();
    }

    public static void build_journal(Model model) throws IOException {

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource journalResource = model.getResource(Data_config.JOURNAL_BASE_URL);
        Property journalNameProp = model.getProperty(Data_config.JOURNAL_NAME_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.JOURNAL_PATH));
        String row;

        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String journalID = row_data[0];
            String journalName = row_data[1];

            String journalURI = journalID;

            // Generate the Model for the ABOX triples
            Resource currentJournal = model.createResource(Data_config.DBPEDIA_INSTANCE_URL + journalURI)
                    .addLiteral(journalNameProp, journalName);
            model.add(model.createStatement(currentJournal, rdfType, journalResource));
        }
        csvReader.close();
    }

    public static void build_conference(Model model) throws IOException {

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource conferenceResource = model.getResource(Data_config.CONF_BASE_URL);
        Property conferenceNameProp = model.getProperty(Data_config.CONFERENCE_NAME_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.CONFERENCE_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String conferenceURI = row_data[0];
            String conferenceName = row_data[1];

            //String conferenceName = cName.replaceAll("[ -]", "_");

            Resource currentConference = model.createResource(Data_config.DBPEDIA_INSTANCE_URL + conferenceURI)
                    .addLiteral(conferenceNameProp, conferenceName);
            model.add(model.createStatement(currentConference, rdfType, conferenceResource));
        }
        csvReader.close();
    }

    public static void build_keyword(Model model) throws IOException {

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource keywordResource = model.getResource(Data_config.KEYWORD_BASE_URL);
        Property keywordNameProp = model.getProperty(Data_config.KEYWORD_NAME_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.KEYWORD_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String keywordURI = row_data[0];
            String keywordName = row_data[1];

            //String keywordName = kName.replace(" ", "_");

            Resource currentKeyword = model.createResource(Data_config.BASE_URL + keywordURI)
                    .addLiteral(keywordNameProp, keywordName);
            model.add(model.createStatement(currentKeyword, rdfType, keywordResource));
        }
        csvReader.close();
    }

    public static void author_belongs_to_affiliation(Model model) throws IOException {

        Property belongsTo = model.getProperty(Data_config.AUTHOR_ORGANISATION_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.BELONGS_TO_AFFILIATION_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String authorURI = row_data[0];
            String affiliationURI = row_data[1];

            Resource authorResource = model.getResource(Data_config.BASE_URL + authorURI);
            Resource affiliationResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + affiliationURI);

            model.add(model.createStatement(authorResource, belongsTo, affiliationResource));
        }
        csvReader.close();
    }

    public static void build_makes_review(Model model) throws IOException {

        Property makes = model.getProperty(Data_config.AUTHOR_REVIEW_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.MAKES_REVIEW_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String authorURI = row_data[0];
            String reviewURI = row_data[1];

            Resource authorResource = model.getResource(Data_config.BASE_URL + authorURI);
            Resource reviewResource = model.getResource(Data_config.BASE_URL + reviewURI);

            model.add(model.createStatement(authorResource, makes, reviewResource));
        }
        csvReader.close();
    }

    public static void build_about_article(Model model) throws IOException {

        Property about = model.getProperty(Data_config.REVIEW_ARTICLE_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.ABOUT_ARTICLE_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String reviewURI = row_data[0];
            String articleURI = row_data[1];

            Resource articleResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + articleURI);
            Resource reviewResource = model.getResource(Data_config.BASE_URL + reviewURI);

            model.add(model.createStatement(reviewResource, about, articleResource));
        }
        csvReader.close();
    }

    public static void build_cites_article(Model model) throws IOException {

        Property cites = model.getProperty(Data_config.ARTICLE_CITES_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.CITES_ARTICLE_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String articleURI = row_data[0];
            String citedArticleURI = row_data[1];

            Resource articleResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + articleURI);
            Resource citedArticleResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + citedArticleURI);

            model.add(model.createStatement(articleResource, cites, citedArticleResource));
        }
        csvReader.close();
    }

    public static void build_written_by_author(Model model) throws IOException {

        Property written_by = model.getProperty(Data_config.ARTICLE_AUTHOR_PROPERTY_URL);
        Property corresponds_to = model.getProperty(Data_config.ARTICLECORR_AUTHOR_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.WRITTEN_BY_AUTHOR_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String articleURI = row_data[0];
            String authorURI = row_data[1];
            String corresponding = row_data[2];

            Resource articleResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + articleURI);
            Resource authorResource = model.getResource(Data_config.BASE_URL + authorURI);

            model.add(model.createStatement(articleResource, written_by, authorResource));
            if (!(corresponding.equals("False"))) {
                model.add(model.createStatement(articleResource, corresponds_to, authorResource));
            }
        }
        csvReader.close();
    }

    public static void build_presented_in_conference(Model model) throws IOException {

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource article_conferenceResource = model.getResource(Data_config.ARTICLE_CONFERENCE_BASE_URL);
        Property presented_in = model.getProperty(Data_config.ARTICLE_ARTCONF_PROPERTY_URL);
        Property belongs_to_conf = model.getProperty(Data_config.ARTCONF_CONFERENCE_PROPERTY_URL);
        Property conference_edition = model.getProperty(Data_config.CONFERENCE_EDITION_PROPERTY_URL);
        Property conference_period = model.getProperty(Data_config.CONFERENCE_PERIOD_PROPERTY_URL);
        Property conference_venue = model.getProperty(Data_config.CONFERENCE_VENUE_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.PRESENTED_IN_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String articleURI = row_data[0];
            String conferenceURI = row_data[1];
            String venueName = row_data[2];
            String periodData = row_data[3];
            String edition = row_data[4];

            String article_conferenceURI = articleURI + "_" + conferenceURI;

            Resource articleResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + articleURI);
            Resource conferenceResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + conferenceURI);

            Resource currentArtConf = model.createResource(Data_config.BASE_URL + article_conferenceURI)
                    .addLiteral(conference_edition, edition)
                    .addLiteral(conference_venue, venueName)
                    .addLiteral(conference_period, periodData);
            model.add(model.createStatement(currentArtConf, rdfType, article_conferenceResource));
            model.add(model.createStatement(articleResource, presented_in, currentArtConf));
            model.add(model.createStatement(currentArtConf, belongs_to_conf, conferenceResource));
        }
        csvReader.close();
    }

    public static void build_published_in_journal(Model model) throws IOException {

        Property rdfType = model.getProperty(Data_config.RDFTYPE_URL);
        Resource article_journalResource = model.getResource(Data_config.ARTICLE_JOURNAL_BASE_URL);
        Property published_in = model.getProperty(Data_config.ARTICLE_ARTJOUR_PROPERTY_URL);
        Property belongs_to_jour = model.getProperty(Data_config.ARTJOUR_JOURNAL_PROPERTY_URL);
        Property volumeProperty = model.getProperty(Data_config.JOURNAL_VOLUME_PROPERTY_URL);
        Property yearProperty = model.getProperty(Data_config.JOURNAL_PUBLICATIONDATE_PROPERTY_URL);
        Property numberProperty = model.getProperty(Data_config.JOURNAL_NUMBER_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.PUBLISHED_IN_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(",");

            String articleURI = row_data[0];
            String journalURI = row_data[1];
            String volumeName = row_data[2];
            String year = row_data[3];
            String number = row_data[4];

            String relationshipURI = articleURI + "_" + journalURI;

            Resource articleResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + articleURI);
            Resource journalResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + journalURI);

            Resource currentArtJour = model.createResource(Data_config.BASE_URL + relationshipURI);
            if (!(number.equals("NaN"))) {
                currentArtJour.addLiteral(numberProperty, number);
            }
            if (!(volumeName.equals("NaN"))) {
                currentArtJour.addLiteral(volumeProperty, volumeName);
            }
            if (!(year.equals("NaN"))) {
                currentArtJour.addLiteral(yearProperty, year);
            }
            model.add(model.createStatement(currentArtJour, rdfType, article_journalResource));
            model.add(model.createStatement(articleResource, published_in, currentArtJour));
            model.add(model.createStatement(currentArtJour, belongs_to_jour, journalResource));
        }
        csvReader.close();
    }

    public static void build_has_keyword(Model model) throws IOException {

        Property has = model.getProperty(Data_config.ARTICLE_KEYWORD_PROPERTY_URL);

        BufferedReader csvReader = new BufferedReader(new FileReader(Data_config.HAS_KEYWORD_PATH));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] row_data = row.split(";");

            String articleURI = row_data[0];
            String keywordURI = row_data[1];

            Resource articleResource = model.getResource(Data_config.DBPEDIA_INSTANCE_URL + articleURI);
            Resource keywordResource = model.getResource(Data_config.BASE_URL + keywordURI);

            model.add(model.createStatement(articleResource, has, keywordResource));
        }
        csvReader.close();
    }
}

