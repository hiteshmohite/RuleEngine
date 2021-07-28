package com.dtcc.ruleengine.engine;

import com.dtcc.ruleengine.model.Metadata;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleExecutorEngine <T> {

    public List<T> execute(List<T> objectsList, Object object)
    {
        Metadata metadata = (Metadata)object;
        KieContainer kieClasspathContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession(metadata.getKieSessionName());
        objectsList.forEach(kieSession::insert);

        System.out.println("==== DROOLS SESSION START ==== ");
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("==== DROOLS SESSION END ==== ");

        System.out.println("==== OBJECTS AFTER DROOLS SESSION === ");

        return objectsList;
    }
}
