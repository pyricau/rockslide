package info.piwai.cv.gwt.client.content.skills;

import info.piwai.cv.gwt.client.content.CV.Sections;
import info.piwai.cv.gwt.client.content.HeaderChapter;
import info.piwai.cv.gwt.client.content.WIP;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Skills extends HeaderChapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Title.binder);

        // Java 5/6 (SCJP 91%), PHP 5, C, XML, XHTML, CSS, Javascript, C++,
        // Ruby, ADA, Python, Prolog, DarkBasic Pro, LaTeX
        addPresentable(new WIP("Computer Languages"), "ComputerLanguages");

        /*
         * Build : Maven, Hudson/Jenkins, Sonar
         * 
         * VCS : Git, SVN
         * 
         * Eclipse
         * 
         * Hacker tools : Firebug, Charles Proxy, nmap
         */
        addPresentable(new WIP("Dev Tools"), "DevTools");

        // Android 2.2, Spring 3.0 (IoC/MVC/AOP), Hibernate, GWT 2.0, Guice,
        // RoboGuice, JUnit 4, Mockito, APT, CodeModel, Gson, Jackson, JEE 5,
        // JAX-RS, EJB3, ejb3unit, RRDTool, RRD4J, symfony (1.0 et 1.2), Ruby On
        // Rails, SDL, script.aculo.us, Prototype, Struts
        addPresentable(new WIP("Frameworks"), "Frameworks");

        /*
         * Servers : JBoss, WebSphere AS, Tomcat Web Servers,Apache OS : Linux->
         * Android, Ubuntu, MacOS, Windows DB : MySQL, SQLite, PostgreSQL,
         * Oracle
         */
        addPresentable(new WIP("OS / Servers / Databases"), "OS-Servers-DB");

        // English, french, spanish, swedish
        addPresentable(new WIP("Spoken Languages"), "SpokenLanguages");

        // Scrum, GTD, TDD, ISO 9001v2000
        addPresentable(new WIP("Methods"), "Methods");

        // logistique / supervision / maintenance, finance
        addPresentable(new WIP("Functional Skills"), "FunctionalSkills");

        addSlide(Sections.binder);
    }
}
