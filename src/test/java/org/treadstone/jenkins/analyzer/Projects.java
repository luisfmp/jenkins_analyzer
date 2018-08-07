package org.treadstone.jenkins.analyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Projects {

    ASUP("snow-activities", "snow-activities-api", new ArrayList<String>(
      Arrays.asList("automation-test-snowui", "automation-test-api", "automation-test-ui"))),
    CROSS_U("snow-cross-u", "snow-cross-u", new ArrayList<String>(
      Arrays.asList("automation-test-snowui", "automation-test-api", "automation-test-ui"))),
    DECORATING_SUPPORT("snow-decorating-support", "snow-decorating-support", new
      ArrayList<String>( Arrays.asList("automation-test-snowui", "automation-test-api",
      "automation-test-ui"))),
    LSC("snow-labor-service-center", "snow-labor-service-center", new
      ArrayList<String>( Arrays.asList("automation-test-snowui", "automation-test-ui"))),
    CAST_CHOIR("snow-cast-choir", "snow-cast-choir", new ArrayList<String>(
      Arrays.asList("automation-test-snowui", "automation-test-api", "automation-test-ui"))),
    CSEP("snow-csep", "snow-csep", new ArrayList<String>( Arrays.asList("automation-test-snowui",
      "automation-test-api", "automation-test-ui"))),
    VACATION_PLANNER("snow-vacation-planner",
      "snow-vacation-planner", new ArrayList<String>( Arrays.asList("automation-test-snowui",
      "automation-test-api", "automation-test-ui"))),
    HUB("snow-hub", "snow-hub", new ArrayList<String>(Arrays.asList("automation-test-snowui",
            "automation-test-api", "automation-test-ui"))),
    WD_LEGACY("snow-wd-legacy", "snow-wd-legacy", new ArrayList<String>(
            Arrays.asList("automation-test-snowui", "automation-test-api", "automation-test-ui")));

    private Projects(String jenkinsName, String githubName, List<String> typesSupported) {
        this.jenkinsName = jenkinsName;
        this.githubName = githubName;
        this.typesSupported = typesSupported;
    }

    private String jenkinsName;
    private String githubName;
    private List<String> typesSupported;

    public String getJenkinsName() {
        return jenkinsName;
    }

    public void setJenkinsName(String jenkinsName) {
        this.jenkinsName = jenkinsName;
    }

    public String getGithubName() {
        return githubName;
    }

    public void setGithubName(String githubName) {
        this.githubName = githubName;
    }

    public List<String> getTypesSupported() {
        return typesSupported;
    }

    public void setTypesSupported(List<String> typesSupported) {
        this.typesSupported = typesSupported;
    }

}
