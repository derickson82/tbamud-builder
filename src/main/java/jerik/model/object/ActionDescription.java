package jerik.model.object;

/**
 * 
 * <pre>
1.4 Control Characters 
In a manner similar to the printf() family of functions, act() uses control 
characters. However, instead of using the % symbol, act() uses the $ character 
to indicate control characters. 

$n Write name, short description, or someone, for ch, depending on whether 
ch is a PC, a NPC, or an invisible PC/NPC. 
$N Like $n, except insert the text for vict_obj.*
$m him, her, or it, depending on the gender of ch. 
$M Like $m, for vict_obj.*
$s his, her,or it, depending on the gender of ch. 
$S Like $s, for vict_obj.* 
$e he, she, it, depending on the gender of ch. 
$E Like $e, for vict_obj.*
$o Name or something for obj, depending on visibility. 
$O Like $o, for vict_obj.*
$p Short description or something for obj. 
$P Like $p for vict_obj.*
$a an ora, depending on the first character of objs name. 
$A Like $a, for vict_obj.*
$T Prints the string pointed to by vict_obj.*
$F Processes the string pointed to by vict_obj with the fname() function prior
to printing.*
$u Processes the buffer and uppercases the first letter of the previous word 
(the word immediately prior to the control code). If there is no previous word,
no action is taken. 
$U Processes the buffer and uppercases the first letter of the following word 
(the word immediately after to the control code). If there is no following 
word, no action is taken. 
$$ Print the character $. 

 * @author derickson82
 *
 */
public class ActionDescription {

}
