package graph_ontology.abox_schema;

public class Data_config {
    public static final String BASE_URL = "http://www.semanticweb.org/Lab3_NazarchukHuete#";
    public static final String DBPEDIA_CLASS_URL = "http://dbpedia.org/ontology/";
    public static final String DBPEDIA_INSTANCE_URL = "http://dbpedia.org/resource/";
    public static final String OUTPUT_PATH = "src/main/resources/output/";
    public static final String RDFTYPE_URL = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";

    // nodes data
    public static final String AFFILIATION_PATH = "src/main/resources/affiliation_node.csv";
    public static final String AUTHOR_PATH = "src/main/resources/author_node.csv";
    public static final String ARTICLE_PATH = "src/main/resources/article_node.csv";
    public static final String REVIEW_PATH = "src/main/resources/review_node.csv";
    public static final String JOURNAL_PATH = "src/main/resources/journal_node.csv";
    public static final String CONFERENCE_PATH = "src/main/resources/conference_workshop_node.csv";
    public static final String KEYWORD_PATH = "src/main/resources/keyword_node.csv";

    // relationships data
    public static final String BELONGS_TO_AFFILIATION_PATH = "src/main/resources/belongs_relationship.csv";
    public static final String MAKES_REVIEW_PATH = "src/main/resources/makes_relationship.csv";
    public static final String ABOUT_ARTICLE_PATH = "src/main/resources/about_relationship.csv";
    public static final String CITES_ARTICLE_PATH = "src/main/resources/cites_relationship.csv";
    public static final String WRITTEN_BY_AUTHOR_PATH = "src/main/resources/writes_relationship.csv";
    public static final String HAS_KEYWORD_PATH = "src/main/resources/has_keyword_relationship.csv";
    public static final String PRESENTED_IN_PATH = "src/main/resources/presented_in_relationship.csv";
    public static final String PUBLISHED_IN_PATH = "src/main/resources/published_in_relationship.csv";

    // Class IRIs
    public static final String AUTHOR_BASE_URL = BASE_URL + "Author";
    public static final String COMPANY_BASE_URL = DBPEDIA_CLASS_URL + "Company";
    public static final String UNIVERSITY_BASE_URL = DBPEDIA_CLASS_URL + "University";
    public static final String ARTICLE_BASE_URL = DBPEDIA_CLASS_URL + "Article";
    public static final String CONF_BASE_URL = DBPEDIA_CLASS_URL + "AcademicConference";
    public static final String JOURNAL_BASE_URL = DBPEDIA_CLASS_URL + "AcademicJournal";
    public static final String REVIEW_BASE_URL = BASE_URL + "Review";
    public static final String KEYWORD_BASE_URL = BASE_URL + "Keyword";
    public static final String ARTICLE_CONFERENCE_BASE_URL = BASE_URL + "Article_Conference";
    public static final String ARTICLE_JOURNAL_BASE_URL = BASE_URL + "Article_Journal";

    // DataType Properties IRIs
    public static final String JOURNAL_PUBLICATIONDATE_PROPERTY_URL = DBPEDIA_CLASS_URL + "finalPublicationYear";
    public static final String ARTICLE_PUBLICATIONDATE_PROPERTY_URL = DBPEDIA_CLASS_URL + "lastPublicationDate";
    public static final String ARTICLE_NUMBER_PROPERTY_URL = BASE_URL + "article_number";
    public static final String ARTICLE_PAGES_PROPERTY_URL = BASE_URL + "article_pages";
    public static final String ARTICLE_TITLE_PROPERTY_URL = BASE_URL + "article_title";
    public static final String AUTHOR_NAME_PROPERTY_URL = BASE_URL + "author_name";
    public static final String COMPANY_NAME_PROPERTY_URL = BASE_URL + "company_name";
    public static final String CONFERENCE_EDITION_PROPERTY_URL = BASE_URL + "conference_edition";
    public static final String CONFERENCE_NAME_PROPERTY_URL = BASE_URL + "conference_name";
    public static final String CONFERENCE_PERIOD_PROPERTY_URL = BASE_URL + "conference_period";
    public static final String CONFERENCE_VENUE_PROPERTY_URL = BASE_URL + "conference_venue";
    public static final String JOURNAL_NAME_PROPERTY_URL = BASE_URL + "journal_name";
    public static final String JOURNAL_NUMBER_PROPERTY_URL = BASE_URL + "journal_number";
    public static final String JOURNAL_VOLUME_PROPERTY_URL = BASE_URL + "journal_volume";
    public static final String KEYWORD_NAME_PROPERTY_URL = BASE_URL + "keyword_name";
    public static final String REVIEW_CONTENT_PROPERTY_URL = BASE_URL + "review_content";
    public static final String REVIEW_DECISION_PROPERTY_URL = BASE_URL + "review_decision";
    public static final String UNIVERSITY_NAME_PROPERTY_URL = BASE_URL + "university_name";

    // ObjectType Properties
    public static final String REVIEW_ARTICLE_PROPERTY_URL = BASE_URL + "about";
    public static final String AUTHOR_ORGANISATION_PROPERTY_URL = BASE_URL + "belongs";
    public static final String ARTCONF_CONFERENCE_PROPERTY_URL = BASE_URL + "belongs_to_conf";
    public static final String ARTJOUR_JOURNAL_PROPERTY_URL = BASE_URL + "belongs_to_jour";
    public static final String ARTICLE_CITES_PROPERTY_URL = BASE_URL + "cites";
    public static final String ARTICLECORR_AUTHOR_PROPERTY_URL = BASE_URL + "corresponds_to";
    public static final String ARTICLE_KEYWORD_PROPERTY_URL = BASE_URL + "has";
    public static final String AUTHOR_REVIEW_PROPERTY_URL = BASE_URL + "makes";
    public static final String ARTICLE_ARTCONF_PROPERTY_URL = BASE_URL + "presented_in";
    public static final String ARTICLE_ARTJOUR_PROPERTY_URL = BASE_URL + "published_in";
    public static final String ARTICLE_AUTHOR_PROPERTY_URL = BASE_URL + "written_by";


}