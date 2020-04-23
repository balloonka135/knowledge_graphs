package graph_ontology.abox_schema;

public class Data_config {
    public static final String BASE_URL = "http://www.semanticweb.org/";
    public static final String PROPERTY_URL = BASE_URL+"property/";
    public static final String RESOURCE_URL = BASE_URL+"resource/";

    public static final String OUTPUT_PATH = "src/main/resources/output/";

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

}