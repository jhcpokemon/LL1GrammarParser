LL(1)语法解析器
定义类
<pre><code>
Rule(String topInAnalyse,String topInEnter,String ruler)
List `<Rule>` rules
给定的表为
Rule("E","i","E→TE'")
Rule("E","(","E→TE'")
Rule("E'","+","E'→+TE'")
Rule("E'",")","E'→ε")
Rule("E'","#","E'→ε")
Rule("T","i","T→FT'")
Rule("T","(","T→FT'")
Rule("T'","+","T'→ε")
Rule("T'","\*","T'→*FT'")
Rule("T'",")","T'→ε")
Rule("T'","#","T'→ε")
Rule("F","i","F→i")
Rule("F","(","F→(E)")
</code></pre>
