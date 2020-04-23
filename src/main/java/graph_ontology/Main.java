package graph_ontology;

import graph_ontology.abox_schema.Schema_builder;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("-affiliation")) {
            Schema_builder.build_affiliation();
        } else if (args[0].equals("-author")){
            Schema_builder.build_author();
        } else if (args[0].equals("-article")){
            Schema_builder.build_article();
        } else if (args[0].equals("-review")){
            Schema_builder.build_review();
        } else if (args[0].equals("-journal")){
            Schema_builder.build_journal();
        } else if (args[0].equals("-conference")){
            Schema_builder.build_conference();
        } else if (args[0].equals("-keyword")){
            Schema_builder.build_keyword();
        } else if (args[0].equals("-belongs_to_affiliation")){
            Schema_builder.build_belongs_to_affiliation();
        } else if (args[0].equals("-makes_review")){
            Schema_builder.build_makes_review();
        } else if (args[0].equals("-about_article")){
            Schema_builder.build_about_article();
        } else if (args[0].equals("-cites_article")){
            Schema_builder.build_cites_article();
        } else if (args[0].equals("-written_by_author")){
            Schema_builder.build_written_by_author();
        } else if (args[0].equals("-presented_in_conference")){
            Schema_builder.build_presented_in_conference();
        } else if (args[0].equals("-published_in_journal")){
            Schema_builder.build_published_in_journal();
        } else if (args[0].equals("-has_keyword")){
            Schema_builder.build_has_keyword();
        } else if (args[0].equals("-all")){
            Schema_builder.build_affiliation();
            Schema_builder.build_author();
            Schema_builder.build_review();
            Schema_builder.build_article();
            Schema_builder.build_journal();
            Schema_builder.build_conference();
            Schema_builder.build_keyword();
            Schema_builder.build_belongs_to_affiliation();
            Schema_builder.build_makes_review();
            Schema_builder.build_about_article();
            Schema_builder.build_cites_article();
            Schema_builder.build_written_by_author();
            Schema_builder.build_presented_in_conference();
            Schema_builder.build_published_in_journal();
            Schema_builder.build_has_keyword();
        }
    }
}