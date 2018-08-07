package org.treadstone.jenkins.analyzer;

import java.util.List;

/**
 * Created by jose.oropeza on 12/27/2017.
 */
public enum Users {

    /*
     * JOSE("@jose.x.oropeza.-nd", new ArrayList<String>( Arrays.asList("roberto",
     * "jose.oropeza"))), NALLINI("@nallini", new ArrayList<String>( Arrays.asList("gurram.nallini",
     * "nallini.gurram", "nalini.gurram"))), LUIS("@luis.x.martinez.-nd", new ArrayList<String>(
     * Arrays.asList("luis.martinez")))
     */
    /*
     * , IMRAN("@imran.x.khan.-nd", new ArrayList<String>( Arrays.asList("imran.khan"))),
     * ERICK("@erick.x.ricardez.-nd", new ArrayList<String>( Arrays.asList("erick.ricardez"))),
     * GONZALO("@gonzalo.x.moreno.-nd", new ArrayList<String>( Arrays.asList("g.moreno")))
     */;

    private Users(String slack, List<String> names) {
        this.slack = slack;
        this.names = names;
    }

    private String slack;
    private List<String> names;

    public String getSlack() {
        return slack;
    }

    public void setSlack(String slack) {
        this.slack = slack;
    }

    public List<String> getKnownNames() {
        return names;
    }

}
