var pairs =
{
"edit":{"global":1}
,"global":{"claim":1,"settings":1,"skew":1}
,"claim":{"settings":1,"incoming":1}
,"settings":{"screen":1,"edit":1,"open":1,"click":1,"audience":1,"changes":1}
,"screen":{"screen":1,"heading":1,"add":1,"click":1,"global":1}
,"heading":{"security":1}
,"security":{"jwt":1,"menu":1}
,"jwt":{"edit":1,"security":1,"return":1,"screen":1,"provide":1,"issuer":1,"expiry":1}
,"add":{"edit":1}
,"open":{"edit":1}
,"click":{"jwt":1,"edit":1,"return":1}
,"menu":{"navigation":1}
,"navigation":{"panel":1}
,"panel":{"click":1}
,"return":{"jwt":1}
,"audience":{"specifies":1,"value":1,"(aud)":1}
,"specifies":{"audience":1,"maximum":1}
,"value":{"integration":1,"against":1,"max":1}
,"integration":{"server":1}
,"server":{"integration":1,"validates":1,"clocks":1,"global":1}
,"validates":{"value":1}
,"against":{"audience":1}
,"(aud)":{"claim":1}
,"incoming":{"jwt":1}
,"provide":{"valid":1,"positive":1}
,"valid":{"string":1}
,"string":{"uri":1}
,"uri":{"audience":1}
,"max":{"global":1}
,"skew":{"(in":1}
,"(in":{"seconds)":1}
,"seconds)":{"specifies":1}
,"maximum":{"number":1}
,"number":{"seconds":1}
,"seconds":{"jwt":1}
,"issuer":{"integration":1}
,"clocks":{"differ":1}
,"differ":{"allow":1}
,"allow":{"jwt":1}
,"expiry":{"validation":1}
,"validation":{"succeed":1}
,"succeed":{"provide":1}
,"positive":{"integer":1}
,"integer":{"zero":1}
,"zero":{"save":1}
,"save":{"changes":1}
,"changes":{"updates":1,"effect":1}
,"updates":{"integration":1}
,"effect":{"immediately":1}
,"immediately":{"related":1}
,"related":{"topics":1}
}
;Search.control.loadWordPairs(pairs);