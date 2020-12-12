package ru.mirea.pois;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import ru.mirea.pois.data.*;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestAll {

    @Test
    public void test1() {
        try {
            InternalKnowledgeBase kBase = prepareKnowledgeBase(Arrays.asList(
                    new File("rules/loyalty.drl")));
            KieSession kSession = kBase.newKieSession();
            // typically we want to consider today but we may decide to schedule
            // emails in the future or we may want to run tests using a different date
            LocalDate dayToConsider = LocalDate.now();

            loadDataIntoSession(kSession, new Customer(
                    "Vasya",
                    1500,
                    1,
                    3000
            ));

            kSession.fireAllRules();
            Model model = (Model) kSession.getGlobal("model");

            Assert.assertEquals(1380.0, model.getCost(), 0.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            InternalKnowledgeBase kBase = prepareKnowledgeBase(Arrays.asList(
                    new File("rules/loyalty.drl")));
            KieSession kSession = kBase.newKieSession();
            // typically we want to consider today but we may decide to schedule
            // emails in the future or we may want to run tests using a different date
            LocalDate dayToConsider = LocalDate.now();

            loadDataIntoSession(kSession, new Customer(
                    "Petya",
                    2500,
                    2,
                    5000
            ));

            kSession.fireAllRules();
            Model model = (Model) kSession.getGlobal("model");

            Assert.assertEquals(2125.0, model.getCost(), 0.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadDataIntoSession(KieSession kieSession, Customer customer) {


        kieSession.insert(customer);

        kieSession.setGlobal("model", new Model());

    }

    private InternalKnowledgeBase prepareKnowledgeBase(List<File> files) {
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        files.forEach(i -> knowledgeBuilder.add(ResourceFactory.newFileResource(i), ResourceType.DRL));

        KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();

        if (!errors.isEmpty()) {
            for (KnowledgeBuilderError error : errors) {
                System.out.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }

        InternalKnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
        kBase.addPackages(knowledgeBuilder.getKnowledgePackages());

        return kBase;
    }
}
