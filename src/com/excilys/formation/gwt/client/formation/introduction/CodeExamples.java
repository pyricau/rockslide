package com.excilys.formation.gwt.client.formation.introduction;

public class CodeExamples {

    // TODO find a way to write strings in a template
    public static final String EXAMPLE = "" //
            + "package fr.koala.gwt.introduction.client;\n" //
            + "// [...]\n" //
            + "public class Introduction implements EntryPoint {\n" //
            + "\n" //
            + "    public void onModuleLoad() {\n" //
            + "        // Creation d'un texte\n" //
            + "        Label label = new Label(\"Salut tout le monde !\");\n" //
            + "        RootPanel.get().add(label);\n" //
            + "        // Creation d'un bouton\n" //
            + "        Button button = new Button(\"Cliquez moi\");\n" //
            + "        button.addClickHandler(new ClickHandler() {\n" //
            + "            public void onClick(ClickEvent event) {\n" //
            + "                Window.alert(\"Mais c'est trop simple!\");\n" //
            + "            }\n" //
            + "        });\n" //
            + "        RootPanel.get().add(button);\n" //
            + "    }\n" //
            + "}\n" //

    ;

}
