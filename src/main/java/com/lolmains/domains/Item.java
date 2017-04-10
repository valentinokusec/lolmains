package com.lolmains.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	private int itemId;

	private int gold;
	
	private int type;
	
	private String imageId;
	
	private String name;

	private String description;


	
	 private Double Armor, FlatAttackSpeedMod, FlatBlockMod, FlatCritChanceMod, FlatCritDamageMod, FlatEXPBonus, FlatEnergyPoolMod, FlatEnergyRegenMod,
     HP, FlatHPRegenMod, FlatMPPoolMod, FlatMPRegenMod, FlatMagicDamageMod, FlatMovementSpeedMod, FlatPhysicalDamageMod, FlatSpellBlockMod,
     PercentArmorMod, PercentAttackSpeedMod, PercentBlockMod, PercentCritChanceMod, PercentCritDamageMod, PercentDodgeMod, PercentEXPBonus,
     PercentHPPoolMod, HPRegen, PercentLifeStealMod, PercentMPPoolMod, PercentMPRegenMod, PercentMagicDamageMod, PercentMovementSpeedMod,
     PercentPhysicalDamageMod, PercentSpellBlockMod, PercentSpellVampMod, rFlatArmorModPerLevel, rFlatArmorPenetrationMod,
     rFlatArmorPenetrationModPerLevel, rFlatCritChanceModPerLevel, rFlatCritDamageModPerLevel, rFlatDodgeMod, rFlatDodgeModPerLevel,
     rFlatEnergyModPerLevel, rFlatEnergyRegenModPerLevel, rFlatGoldPer10Mod, rFlatHPModPerLevel, rFlatHPRegenModPerLevel, rFlatMPModPerLevel,
     rFlatMPRegenModPerLevel, rFlatMagicDamageModPerLevel, rFlatMagicPenetrationMod, rFlatMagicPenetrationModPerLevel, rFlatMovementSpeedModPerLevel,
     rFlatPhysicalDamageModPerLevel, rFlatSpellBlockModPerLevel, rFlatTimeDeadMod, rFlatTimeDeadModPerLevel, rPercentArmorPenetrationMod,
     rPercentArmorPenetrationModPerLevel, rPercentAttackSpeedModPerLevel, rPercentCooldownMod, rPercentCooldownModPerLevel, rPercentMagicPenetrationMod,
     rPercentMagicPenetrationModPerLevel, rPercentMovementSpeedModPerLevel, rPercentTimeDeadMod, rPercentTimeDeadModPerLevel;
	
	 
	 
	 public Item()
	 {
		 
	 }
	public Item(int itemId,int type,  int gold, String imageId, String name, String description, 
			Double Armor, Double flatAttackSpeedMod, Double flatBlockMod, Double flatCritChanceMod,
			Double flatCritDamageMod, Double flatEXPBonus, Double flatEnergyPoolMod, Double flatEnergyRegenMod,
			Double HP, Double flatHPRegenMod, Double flatMPPoolMod, Double flatMPRegenMod,
			Double flatMagicDamageMod, Double flatMovementSpeedMod, Double flatPhysicalDamageMod,
			Double flatSpellBlockMod, Double percentArmorMod, Double percentAttackSpeedMod, Double percentBlockMod,
			Double percentCritChanceMod, Double percentCritDamageMod, Double percentDodgeMod, Double percentEXPBonus,
			Double percentHPPoolMod, Double HPRegen, Double percentLifeStealMod, Double percentMPPoolMod,
			Double percentMPRegenMod, Double percentMagicDamageMod, Double percentMovementSpeedMod,
			Double percentPhysicalDamageMod, Double percentSpellBlockMod, Double percentSpellVampMod,
			Double rFlatArmorModPerLevel, Double rFlatArmorPenetrationMod, Double rFlatArmorPenetrationModPerLevel,
			Double rFlatCritChanceModPerLevel, Double rFlatCritDamageModPerLevel, Double rFlatDodgeMod,
			Double rFlatDodgeModPerLevel, Double rFlatEnergyModPerLevel, Double rFlatEnergyRegenModPerLevel,
			Double rFlatGoldPer10Mod, Double rFlatHPModPerLevel, Double rFlatHPRegenModPerLevel,
			Double rFlatMPModPerLevel, Double rFlatMPRegenModPerLevel, Double rFlatMagicDamageModPerLevel,
			Double rFlatMagicPenetrationMod, Double rFlatMagicPenetrationModPerLevel,
			Double rFlatMovementSpeedModPerLevel, Double rFlatPhysicalDamageModPerLevel,
			Double rFlatSpellBlockModPerLevel, Double rFlatTimeDeadMod, Double rFlatTimeDeadModPerLevel,
			Double rPercentArmorPenetrationMod, Double rPercentArmorPenetrationModPerLevel,
			Double rPercentAttackSpeedModPerLevel, Double rPercentCooldownMod, Double rPercentCooldownModPerLevel,
			Double rPercentMagicPenetrationMod, Double rPercentMagicPenetrationModPerLevel,
			Double rPercentMovementSpeedModPerLevel, Double rPercentTimeDeadMod, Double rPercentTimeDeadModPerLevel) {
		super();
		this.itemId = itemId;
		this.type = type;
		this.gold = gold;
		this.imageId = imageId;
		this.name = name;
		this.description = description;
		
		this.Armor = Armor;
		FlatAttackSpeedMod = flatAttackSpeedMod;
		FlatBlockMod = flatBlockMod;
		FlatCritChanceMod = flatCritChanceMod;
		FlatCritDamageMod = flatCritDamageMod;
		FlatEXPBonus = flatEXPBonus;
		FlatEnergyPoolMod = flatEnergyPoolMod;
		FlatEnergyRegenMod = flatEnergyRegenMod;
		this.HP = HP;
		FlatHPRegenMod = flatHPRegenMod;
		FlatMPPoolMod = flatMPPoolMod;
		FlatMPRegenMod = flatMPRegenMod;
		FlatMagicDamageMod = flatMagicDamageMod;
		FlatMovementSpeedMod = flatMovementSpeedMod;
		FlatPhysicalDamageMod = flatPhysicalDamageMod;
		FlatSpellBlockMod = flatSpellBlockMod;
		PercentArmorMod = percentArmorMod;
		PercentAttackSpeedMod = percentAttackSpeedMod;
		PercentBlockMod = percentBlockMod;
		PercentCritChanceMod = percentCritChanceMod;
		PercentCritDamageMod = percentCritDamageMod;
		PercentDodgeMod = percentDodgeMod;
		PercentEXPBonus = percentEXPBonus;
		PercentHPPoolMod = percentHPPoolMod;
		this.HPRegen = HPRegen;
		PercentLifeStealMod = percentLifeStealMod;
		PercentMPPoolMod = percentMPPoolMod;
		PercentMPRegenMod = percentMPRegenMod;
		PercentMagicDamageMod = percentMagicDamageMod;
		PercentMovementSpeedMod = percentMovementSpeedMod;
		PercentPhysicalDamageMod = percentPhysicalDamageMod;
		PercentSpellBlockMod = percentSpellBlockMod;
		PercentSpellVampMod = percentSpellVampMod;
		this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
		this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
		this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
		this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
		this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
		this.rFlatDodgeMod = rFlatDodgeMod;
		this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
		this.rFlatEnergyModPerLevel = rFlatEnergyModPerLevel;
		this.rFlatEnergyRegenModPerLevel = rFlatEnergyRegenModPerLevel;
		this.rFlatGoldPer10Mod = rFlatGoldPer10Mod;
		this.rFlatHPModPerLevel = rFlatHPModPerLevel;
		this.rFlatHPRegenModPerLevel = rFlatHPRegenModPerLevel;
		this.rFlatMPModPerLevel = rFlatMPModPerLevel;
		this.rFlatMPRegenModPerLevel = rFlatMPRegenModPerLevel;
		this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
		this.rFlatMagicPenetrationMod = rFlatMagicPenetrationMod;
		this.rFlatMagicPenetrationModPerLevel = rFlatMagicPenetrationModPerLevel;
		this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
		this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
		this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
		this.rFlatTimeDeadMod = rFlatTimeDeadMod;
		this.rFlatTimeDeadModPerLevel = rFlatTimeDeadModPerLevel;
		this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
		this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
		this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
		this.rPercentCooldownMod = rPercentCooldownMod;
		this.rPercentCooldownModPerLevel = rPercentCooldownModPerLevel;
		this.rPercentMagicPenetrationMod = rPercentMagicPenetrationMod;
		this.rPercentMagicPenetrationModPerLevel = rPercentMagicPenetrationModPerLevel;
		this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
		this.rPercentTimeDeadMod = rPercentTimeDeadMod;
		this.rPercentTimeDeadModPerLevel = rPercentTimeDeadModPerLevel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Double getFArmor() {
		return Armor;
	}
	public void setArmor(Double flatArmorMod) {
		this.Armor = Armor;
	}
	public Double getFlatAttackSpeedMod() {
		return FlatAttackSpeedMod;
	}
	public void setFlatAttackSpeedMod(Double flatAttackSpeedMod) {
		FlatAttackSpeedMod = flatAttackSpeedMod;
	}
	public Double getFlatBlockMod() {
		return FlatBlockMod;
	}
	public void setFlatBlockMod(Double flatBlockMod) {
		FlatBlockMod = flatBlockMod;
	}
	public Double getFlatCritChanceMod() {
		return FlatCritChanceMod;
	}
	public void setFlatCritChanceMod(Double flatCritChanceMod) {
		FlatCritChanceMod = flatCritChanceMod;
	}
	public Double getFlatCritDamageMod() {
		return FlatCritDamageMod;
	}
	public void setFlatCritDamageMod(Double flatCritDamageMod) {
		FlatCritDamageMod = flatCritDamageMod;
	}
	public Double getFlatEXPBonus() {
		return FlatEXPBonus;
	}
	public void setFlatEXPBonus(Double flatEXPBonus) {
		FlatEXPBonus = flatEXPBonus;
	}
	public Double getFlatEnergyPoolMod() {
		return FlatEnergyPoolMod;
	}
	public void setFlatEnergyPoolMod(Double flatEnergyPoolMod) {
		FlatEnergyPoolMod = flatEnergyPoolMod;
	}
	public Double getFlatEnergyRegenMod() {
		return FlatEnergyRegenMod;
	}
	public void setFlatEnergyRegenMod(Double flatEnergyRegenMod) {
		FlatEnergyRegenMod = flatEnergyRegenMod;
	}
	public Double getHP() {
		return HP;
	}
	public void setHP(Double HP) {
		this.HP = HP;
	}
	public Double getFlatHPRegenMod() {
		return FlatHPRegenMod;
	}
	public void setFlatHPRegenMod(Double flatHPRegenMod) {
		FlatHPRegenMod = flatHPRegenMod;
	}
	public Double getFlatMPPoolMod() {
		return FlatMPPoolMod;
	}
	public void setFlatMPPoolMod(Double flatMPPoolMod) {
		FlatMPPoolMod = flatMPPoolMod;
	}
	public Double getFlatMPRegenMod() {
		return FlatMPRegenMod;
	}
	public void setFlatMPRegenMod(Double flatMPRegenMod) {
		FlatMPRegenMod = flatMPRegenMod;
	}
	public Double getFlatMagicDamageMod() {
		return FlatMagicDamageMod;
	}
	public void setFlatMagicDamageMod(Double flatMagicDamageMod) {
		FlatMagicDamageMod = flatMagicDamageMod;
	}
	public Double getFlatMovementSpeedMod() {
		return FlatMovementSpeedMod;
	}
	public void setFlatMovementSpeedMod(Double flatMovementSpeedMod) {
		FlatMovementSpeedMod = flatMovementSpeedMod;
	}
	public Double getFlatPhysicalDamageMod() {
		return FlatPhysicalDamageMod;
	}
	public void setFlatPhysicalDamageMod(Double flatPhysicalDamageMod) {
		FlatPhysicalDamageMod = flatPhysicalDamageMod;
	}
	public Double getFlatSpellBlockMod() {
		return FlatSpellBlockMod;
	}
	public void setFlatSpellBlockMod(Double flatSpellBlockMod) {
		FlatSpellBlockMod = flatSpellBlockMod;
	}
	public Double getPercentArmorMod() {
		return PercentArmorMod;
	}
	public void setPercentArmorMod(Double percentArmorMod) {
		PercentArmorMod = percentArmorMod;
	}
	public Double getPercentAttackSpeedMod() {
		return PercentAttackSpeedMod;
	}
	public void setPercentAttackSpeedMod(Double percentAttackSpeedMod) {
		PercentAttackSpeedMod = percentAttackSpeedMod;
	}
	public Double getPercentBlockMod() {
		return PercentBlockMod;
	}
	public void setPercentBlockMod(Double percentBlockMod) {
		PercentBlockMod = percentBlockMod;
	}
	public Double getPercentCritChanceMod() {
		return PercentCritChanceMod;
	}
	public void setPercentCritChanceMod(Double percentCritChanceMod) {
		PercentCritChanceMod = percentCritChanceMod;
	}
	public Double getPercentCritDamageMod() {
		return PercentCritDamageMod;
	}
	public void setPercentCritDamageMod(Double percentCritDamageMod) {
		PercentCritDamageMod = percentCritDamageMod;
	}
	public Double getPercentDodgeMod() {
		return PercentDodgeMod;
	}
	public void setPercentDodgeMod(Double percentDodgeMod) {
		PercentDodgeMod = percentDodgeMod;
	}
	public Double getPercentEXPBonus() {
		return PercentEXPBonus;
	}
	public void setPercentEXPBonus(Double percentEXPBonus) {
		PercentEXPBonus = percentEXPBonus;
	}
	public Double getPercentHPPoolMod() {
		return PercentHPPoolMod;
	}
	public void setPercentHPPoolMod(Double percentHPPoolMod) {
		PercentHPPoolMod = percentHPPoolMod;
	}
	public Double getHPRegen() {
		return this.HPRegen;
	}
	public void setHPRegen(Double percentHPRegenMod) {
		HPRegen = percentHPRegenMod;
	}
	public Double getPercentLifeStealMod() {
		return PercentLifeStealMod;
	}
	public void setPercentLifeStealMod(Double percentLifeStealMod) {
		PercentLifeStealMod = percentLifeStealMod;
	}
	public Double getPercentMPPoolMod() {
		return PercentMPPoolMod;
	}
	public void setPercentMPPoolMod(Double percentMPPoolMod) {
		PercentMPPoolMod = percentMPPoolMod;
	}
	public Double getPercentMPRegenMod() {
		return PercentMPRegenMod;
	}
	public void setPercentMPRegenMod(Double percentMPRegenMod) {
		PercentMPRegenMod = percentMPRegenMod;
	}
	public Double getPercentMagicDamageMod() {
		return PercentMagicDamageMod;
	}
	public void setPercentMagicDamageMod(Double percentMagicDamageMod) {
		PercentMagicDamageMod = percentMagicDamageMod;
	}
	public Double getPercentMovementSpeedMod() {
		return PercentMovementSpeedMod;
	}
	public void setPercentMovementSpeedMod(Double percentMovementSpeedMod) {
		PercentMovementSpeedMod = percentMovementSpeedMod;
	}
	public Double getPercentPhysicalDamageMod() {
		return PercentPhysicalDamageMod;
	}
	public void setPercentPhysicalDamageMod(Double percentPhysicalDamageMod) {
		PercentPhysicalDamageMod = percentPhysicalDamageMod;
	}
	public Double getPercentSpellBlockMod() {
		return PercentSpellBlockMod;
	}
	public void setPercentSpellBlockMod(Double percentSpellBlockMod) {
		PercentSpellBlockMod = percentSpellBlockMod;
	}
	public Double getPercentSpellVampMod() {
		return PercentSpellVampMod;
	}
	public void setPercentSpellVampMod(Double percentSpellVampMod) {
		PercentSpellVampMod = percentSpellVampMod;
	}
	public Double getrFlatArmorModPerLevel() {
		return rFlatArmorModPerLevel;
	}
	public void setrFlatArmorModPerLevel(Double rFlatArmorModPerLevel) {
		this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
	}
	public Double getrFlatArmorPenetrationMod() {
		return rFlatArmorPenetrationMod;
	}
	public void setrFlatArmorPenetrationMod(Double rFlatArmorPenetrationMod) {
		this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
	}
	public Double getrFlatArmorPenetrationModPerLevel() {
		return rFlatArmorPenetrationModPerLevel;
	}
	public void setrFlatArmorPenetrationModPerLevel(Double rFlatArmorPenetrationModPerLevel) {
		this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
	}
	public Double getrFlatCritChanceModPerLevel() {
		return rFlatCritChanceModPerLevel;
	}
	public void setrFlatCritChanceModPerLevel(Double rFlatCritChanceModPerLevel) {
		this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
	}
	public Double getrFlatCritDamageModPerLevel() {
		return rFlatCritDamageModPerLevel;
	}
	public void setrFlatCritDamageModPerLevel(Double rFlatCritDamageModPerLevel) {
		this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
	}
	public Double getrFlatDodgeMod() {
		return rFlatDodgeMod;
	}
	public void setrFlatDodgeMod(Double rFlatDodgeMod) {
		this.rFlatDodgeMod = rFlatDodgeMod;
	}
	public Double getrFlatDodgeModPerLevel() {
		return rFlatDodgeModPerLevel;
	}
	public void setrFlatDodgeModPerLevel(Double rFlatDodgeModPerLevel) {
		this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
	}
	public Double getrFlatEnergyModPerLevel() {
		return rFlatEnergyModPerLevel;
	}
	public void setrFlatEnergyModPerLevel(Double rFlatEnergyModPerLevel) {
		this.rFlatEnergyModPerLevel = rFlatEnergyModPerLevel;
	}
	public Double getrFlatEnergyRegenModPerLevel() {
		return rFlatEnergyRegenModPerLevel;
	}
	public void setrFlatEnergyRegenModPerLevel(Double rFlatEnergyRegenModPerLevel) {
		this.rFlatEnergyRegenModPerLevel = rFlatEnergyRegenModPerLevel;
	}
	public Double getrFlatGoldPer10Mod() {
		return rFlatGoldPer10Mod;
	}
	public void setrFlatGoldPer10Mod(Double rFlatGoldPer10Mod) {
		this.rFlatGoldPer10Mod = rFlatGoldPer10Mod;
	}
	public Double getrFlatHPModPerLevel() {
		return rFlatHPModPerLevel;
	}
	public void setrFlatHPModPerLevel(Double rFlatHPModPerLevel) {
		this.rFlatHPModPerLevel = rFlatHPModPerLevel;
	}
	public Double getrFlatHPRegenModPerLevel() {
		return rFlatHPRegenModPerLevel;
	}
	public void setrFlatHPRegenModPerLevel(Double rFlatHPRegenModPerLevel) {
		this.rFlatHPRegenModPerLevel = rFlatHPRegenModPerLevel;
	}
	public Double getrFlatMPModPerLevel() {
		return rFlatMPModPerLevel;
	}
	public void setrFlatMPModPerLevel(Double rFlatMPModPerLevel) {
		this.rFlatMPModPerLevel = rFlatMPModPerLevel;
	}
	public Double getrFlatMPRegenModPerLevel() {
		return rFlatMPRegenModPerLevel;
	}
	public void setrFlatMPRegenModPerLevel(Double rFlatMPRegenModPerLevel) {
		this.rFlatMPRegenModPerLevel = rFlatMPRegenModPerLevel;
	}
	public Double getrFlatMagicDamageModPerLevel() {
		return rFlatMagicDamageModPerLevel;
	}
	public void setrFlatMagicDamageModPerLevel(Double rFlatMagicDamageModPerLevel) {
		this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
	}
	public Double getrFlatMagicPenetrationMod() {
		return rFlatMagicPenetrationMod;
	}
	public void setrFlatMagicPenetrationMod(Double rFlatMagicPenetrationMod) {
		this.rFlatMagicPenetrationMod = rFlatMagicPenetrationMod;
	}
	public Double getrFlatMagicPenetrationModPerLevel() {
		return rFlatMagicPenetrationModPerLevel;
	}
	public void setrFlatMagicPenetrationModPerLevel(Double rFlatMagicPenetrationModPerLevel) {
		this.rFlatMagicPenetrationModPerLevel = rFlatMagicPenetrationModPerLevel;
	}
	public Double getrFlatMovementSpeedModPerLevel() {
		return rFlatMovementSpeedModPerLevel;
	}
	public void setrFlatMovementSpeedModPerLevel(Double rFlatMovementSpeedModPerLevel) {
		this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
	}
	public Double getrFlatPhysicalDamageModPerLevel() {
		return rFlatPhysicalDamageModPerLevel;
	}
	public void setrFlatPhysicalDamageModPerLevel(Double rFlatPhysicalDamageModPerLevel) {
		this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
	}
	public Double getrFlatSpellBlockModPerLevel() {
		return rFlatSpellBlockModPerLevel;
	}
	public void setrFlatSpellBlockModPerLevel(Double rFlatSpellBlockModPerLevel) {
		this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
	}
	public Double getrFlatTimeDeadMod() {
		return rFlatTimeDeadMod;
	}
	public void setrFlatTimeDeadMod(Double rFlatTimeDeadMod) {
		this.rFlatTimeDeadMod = rFlatTimeDeadMod;
	}
	public Double getrFlatTimeDeadModPerLevel() {
		return rFlatTimeDeadModPerLevel;
	}
	public void setrFlatTimeDeadModPerLevel(Double rFlatTimeDeadModPerLevel) {
		this.rFlatTimeDeadModPerLevel = rFlatTimeDeadModPerLevel;
	}
	public Double getrPercentArmorPenetrationMod() {
		return rPercentArmorPenetrationMod;
	}
	public void setrPercentArmorPenetrationMod(Double rPercentArmorPenetrationMod) {
		this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
	}
	public Double getrPercentArmorPenetrationModPerLevel() {
		return rPercentArmorPenetrationModPerLevel;
	}
	public void setrPercentArmorPenetrationModPerLevel(Double rPercentArmorPenetrationModPerLevel) {
		this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
	}
	public Double getrPercentAttackSpeedModPerLevel() {
		return rPercentAttackSpeedModPerLevel;
	}
	public void setrPercentAttackSpeedModPerLevel(Double rPercentAttackSpeedModPerLevel) {
		this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
	}
	public Double getrPercentCooldownMod() {
		return rPercentCooldownMod;
	}
	public void setrPercentCooldownMod(Double rPercentCooldownMod) {
		this.rPercentCooldownMod = rPercentCooldownMod;
	}
	public Double getrPercentCooldownModPerLevel() {
		return rPercentCooldownModPerLevel;
	}
	public void setrPercentCooldownModPerLevel(Double rPercentCooldownModPerLevel) {
		this.rPercentCooldownModPerLevel = rPercentCooldownModPerLevel;
	}
	public Double getrPercentMagicPenetrationMod() {
		return rPercentMagicPenetrationMod;
	}
	public void setrPercentMagicPenetrationMod(Double rPercentMagicPenetrationMod) {
		this.rPercentMagicPenetrationMod = rPercentMagicPenetrationMod;
	}
	public Double getrPercentMagicPenetrationModPerLevel() {
		return rPercentMagicPenetrationModPerLevel;
	}
	public void setrPercentMagicPenetrationModPerLevel(Double rPercentMagicPenetrationModPerLevel) {
		this.rPercentMagicPenetrationModPerLevel = rPercentMagicPenetrationModPerLevel;
	}
	public Double getrPercentMovementSpeedModPerLevel() {
		return rPercentMovementSpeedModPerLevel;
	}
	public void setrPercentMovementSpeedModPerLevel(Double rPercentMovementSpeedModPerLevel) {
		this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
	}
	public Double getrPercentTimeDeadMod() {
		return rPercentTimeDeadMod;
	}
	public void setrPercentTimeDeadMod(Double rPercentTimeDeadMod) {
		this.rPercentTimeDeadMod = rPercentTimeDeadMod;
	}
	public Double getrPercentTimeDeadModPerLevel() {
		return rPercentTimeDeadModPerLevel;
	}
	public void setrPercentTimeDeadModPerLevel(Double rPercentTimeDeadModPerLevel) {
		this.rPercentTimeDeadModPerLevel = rPercentTimeDeadModPerLevel;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemId=" + itemId + ", gold=" + gold + ", type=" + type + ", imageId=" + imageId
				+ ", name=" + name + ", description=" + description + ", Armor=" + Armor
				+ ", FlatAttackSpeedMod=" + FlatAttackSpeedMod + ", FlatBlockMod=" + FlatBlockMod
				+ ", FlatCritChanceMod=" + FlatCritChanceMod + ", FlatCritDamageMod=" + FlatCritDamageMod
				+ ", FlatEXPBonus=" + FlatEXPBonus + ", FlatEnergyPoolMod=" + FlatEnergyPoolMod
				+ ", FlatEnergyRegenMod=" + FlatEnergyRegenMod + ", HP=" + HP
				+ ", FlatHPRegenMod=" + FlatHPRegenMod + ", FlatMPPoolMod=" + FlatMPPoolMod + ", FlatMPRegenMod="
				+ FlatMPRegenMod + ", FlatMagicDamageMod=" + FlatMagicDamageMod + ", FlatMovementSpeedMod="
				+ FlatMovementSpeedMod + ", FlatPhysicalDamageMod=" + FlatPhysicalDamageMod + ", FlatSpellBlockMod="
				+ FlatSpellBlockMod + ", PercentArmorMod=" + PercentArmorMod + ", PercentAttackSpeedMod="
				+ PercentAttackSpeedMod + ", PercentBlockMod=" + PercentBlockMod + ", PercentCritChanceMod="
				+ PercentCritChanceMod + ", PercentCritDamageMod=" + PercentCritDamageMod + ", PercentDodgeMod="
				+ PercentDodgeMod + ", PercentEXPBonus=" + PercentEXPBonus + ", PercentHPPoolMod=" + PercentHPPoolMod
				+ ", HPRegen=" + HPRegen + ", PercentLifeStealMod=" + PercentLifeStealMod
				+ ", PercentMPPoolMod=" + PercentMPPoolMod + ", PercentMPRegenMod=" + PercentMPRegenMod
				+ ", PercentMagicDamageMod=" + PercentMagicDamageMod + ", PercentMovementSpeedMod="
				+ PercentMovementSpeedMod + ", PercentPhysicalDamageMod=" + PercentPhysicalDamageMod
				+ ", PercentSpellBlockMod=" + PercentSpellBlockMod + ", PercentSpellVampMod=" + PercentSpellVampMod
				+ ", rFlatArmorModPerLevel=" + rFlatArmorModPerLevel + ", rFlatArmorPenetrationMod="
				+ rFlatArmorPenetrationMod + ", rFlatArmorPenetrationModPerLevel=" + rFlatArmorPenetrationModPerLevel
				+ ", rFlatCritChanceModPerLevel=" + rFlatCritChanceModPerLevel + ", rFlatCritDamageModPerLevel="
				+ rFlatCritDamageModPerLevel + ", rFlatDodgeMod=" + rFlatDodgeMod + ", rFlatDodgeModPerLevel="
				+ rFlatDodgeModPerLevel + ", rFlatEnergyModPerLevel=" + rFlatEnergyModPerLevel
				+ ", rFlatEnergyRegenModPerLevel=" + rFlatEnergyRegenModPerLevel + ", rFlatGoldPer10Mod="
				+ rFlatGoldPer10Mod + ", rFlatHPModPerLevel=" + rFlatHPModPerLevel + ", rFlatHPRegenModPerLevel="
				+ rFlatHPRegenModPerLevel + ", rFlatMPModPerLevel=" + rFlatMPModPerLevel + ", rFlatMPRegenModPerLevel="
				+ rFlatMPRegenModPerLevel + ", rFlatMagicDamageModPerLevel=" + rFlatMagicDamageModPerLevel
				+ ", rFlatMagicPenetrationMod=" + rFlatMagicPenetrationMod + ", rFlatMagicPenetrationModPerLevel="
				+ rFlatMagicPenetrationModPerLevel + ", rFlatMovementSpeedModPerLevel=" + rFlatMovementSpeedModPerLevel
				+ ", rFlatPhysicalDamageModPerLevel=" + rFlatPhysicalDamageModPerLevel + ", rFlatSpellBlockModPerLevel="
				+ rFlatSpellBlockModPerLevel + ", rFlatTimeDeadMod=" + rFlatTimeDeadMod + ", rFlatTimeDeadModPerLevel="
				+ rFlatTimeDeadModPerLevel + ", rPercentArmorPenetrationMod=" + rPercentArmorPenetrationMod
				+ ", rPercentArmorPenetrationModPerLevel=" + rPercentArmorPenetrationModPerLevel
				+ ", rPercentAttackSpeedModPerLevel=" + rPercentAttackSpeedModPerLevel + ", rPercentCooldownMod="
				+ rPercentCooldownMod + ", rPercentCooldownModPerLevel=" + rPercentCooldownModPerLevel
				+ ", rPercentMagicPenetrationMod=" + rPercentMagicPenetrationMod
				+ ", rPercentMagicPenetrationModPerLevel=" + rPercentMagicPenetrationModPerLevel
				+ ", rPercentMovementSpeedModPerLevel=" + rPercentMovementSpeedModPerLevel + ", rPercentTimeDeadMod="
				+ rPercentTimeDeadMod + ", rPercentTimeDeadModPerLevel=" + rPercentTimeDeadModPerLevel + "]";
	}


	
}
