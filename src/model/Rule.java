package model;

import java.util.ArrayList;

/**
 * Created by jhcpokemon on 06/02/15.
 */
public class Rule {
    private String topInAnalyse,topInEnter,ruler;
    public Rule(String topInAnalyse,String topInEnter,String ruler){
        this.topInAnalyse = topInAnalyse;
        this.topInEnter = topInEnter;
        this.ruler = ruler;
    }

    public String getTopInAnalyse() {
        return topInAnalyse;
    }

    public String getTopInEnter() {
        return topInEnter;
    }

    public String getRuler() {
        return ruler;
    }

    public ArrayList<Rule> getRules(){
        ArrayList<Rule> rules= new ArrayList<>();
        rules.add(new Rule("E","i","E¡úTE'"));
        rules.add(new Rule("E","(","E¡úTE'"));
        rules.add(new Rule("E'","+","E'¡ú+TE'"));
        rules.add(new Rule("E'",")","E'¡ú¦Å"));
        rules.add(new Rule("E'","#","E'¡ú¦Å"));
        rules.add(new Rule("T","i","T¡úFT'"));
        rules.add(new Rule("T","(","T¡úFT'"));
        rules.add(new Rule("T'","+","T'¡ú¦Å"));
        rules.add(new Rule("T'","*","T'¡ú*FT'"));
        rules.add(new Rule("T'",")","T'¡ú¦Å"));
        rules.add(new Rule("T'","#","T'¡ú¦Å"));
        rules.add(new Rule("F","i","F¡úi"));
        rules.add(new Rule("F","(","F¡ú(E)"));
        return rules;
    }
}
