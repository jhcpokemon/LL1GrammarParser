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

    public static ArrayList<Rule> getRules(){
        ArrayList<Rule> rules= new ArrayList<>();
        rules.add(new Rule("E","i","E\u2192TG"));
        rules.add(new Rule("E","(","E\u2192TG"));
        rules.add(new Rule("G","+","G\u2192+TG"));
        rules.add(new Rule("G",")","G\u2192\u03b5"));
        rules.add(new Rule("G","#","G\u2192\u03b5"));
        rules.add(new Rule("T","i","T\u2192FH"));
        rules.add(new Rule("T","(","T\u2192FH"));
        rules.add(new Rule("H","+","H\u2192\u03b5"));
        rules.add(new Rule("H","*","H\u2192*FH"));
        rules.add(new Rule("H",")","H\u2192\u03b5"));
        rules.add(new Rule("H","#","H\u2192\u03b5"));
        rules.add(new Rule("F","i","F\u2192i"));
        rules.add(new Rule("F","(","F\u2192(E)"));
        return rules;
    }
}
