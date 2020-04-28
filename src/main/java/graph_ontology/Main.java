package graph_ontology;

import graph_ontology.abox_schema.Data_config;
import graph_ontology.abox_schema.Schema_builder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws Exception {
        Model model = ModelFactory.createDefaultModel();
        //Model model2 = ModelFactory.createDefaultModel();

        if (args[0].equals("-affiliation")) {
            Schema_builder.build_affiliation(model);
        } else if (args[0].equals("-author")){
            Schema_builder.build_author(model);
        } else if (args[0].equals("-article")){
            Schema_builder.build_article(model);
        } else if (args[0].equals("-review")){
            Schema_builder.build_review(model);
        } else if (args[0].equals("-journal")){
            Schema_builder.build_journal(model);
        } else if (args[0].equals("-conference")){
            Schema_builder.build_conference(model);
        } else if (args[0].equals("-keyword")){
            Schema_builder.build_keyword(model);
        } else if (args[0].equals("-belongs_to_affiliation")){
            Schema_builder.author_belongs_to_affiliation(model);
        } else if (args[0].equals("-makes_review")){
            Schema_builder.build_makes_review(model);
        } else if (args[0].equals("-about_article")){
            Schema_builder.build_about_article(model);
        } else if (args[0].equals("-cites_article")){
            Schema_builder.build_cites_article(model);
        } else if (args[0].equals("-written_by_author")){
            Schema_builder.build_written_by_author(model);
        } else if (args[0].equals("-presented_in_conference")){
            Schema_builder.build_presented_in_conference(model);
        } else if (args[0].equals("-published_in_journal")){
            Schema_builder.build_published_in_journal(model);
        } else if (args[0].equals("-has_keyword")){
            Schema_builder.build_has_keyword(model);
        } else if (args[0].equals("-all")){
//            Schema_builder.build_affiliation(model);
//            Schema_builder.build_author(model);
//            Schema_builder.build_review(model);
//            Schema_builder.build_article(model);
//            Schema_builder.build_journal(model);
//            Schema_builder.build_conference(model);
//            Schema_builder.build_keyword(model);
//              Schema_builder.author_belongs_to_affiliation(model);
//            Schema_builder.build_makes_review(model);
//            Schema_builder.build_about_article(model);
//            Schema_builder.build_cites_article(model);

            Schema_builder.build_written_by_author(model);

//            Schema_builder.build_presented_in_conference(model);
//            Schema_builder.build_published_in_journal(model);
//            Schema_builder.build_has_keyword(model);
        }
        model.write(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(Data_config.OUTPUT_PATH + "abox_6.nt")), true), "NT");
    }
}