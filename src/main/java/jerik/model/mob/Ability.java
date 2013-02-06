package jerik.model.mob;

/**
 * Enhance Mob specs for each of the abilities listed. Values should be between
 * 3 and 18, but can be between 1 and 25.
 * 
 * TODO Additionally, another e-spec called StrAdd can have a value between 1 and 99
 * 
 * @author derickson82
 *
 */
public enum Ability {
  STR,
  DEX, 
  CON, 
  INT, 
  WIS,
  CHA,
  STR_ADD; // special ability with a range between 1 and 99
}