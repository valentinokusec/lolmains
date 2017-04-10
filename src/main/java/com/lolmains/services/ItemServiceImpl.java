package com.lolmains.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.exception.ConstraintViolationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Mains;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Item;
import com.lolmains.repository.DiscussionDao;
import com.lolmains.repository.ItemDao;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;





@Service
public class ItemServiceImpl implements ItemService {
	
	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	@Autowired
	private ItemDao itemdao;

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemdao.findAll();
	}

	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item addAll() {
		
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey(API_KEY);
		
		List<com.robrua.orianna.type.core.staticdata.Item> itemList=RiotAPI.getItems();
		for (com.robrua.orianna.type.core.staticdata.Item item:itemList) {
			try {
				
			
			Item items=new Item(item.getID(),0, item.getGold().getTotal(), item.getImage().getFull(), item.getName(), item.getPlainText(), item.getStats().getFlatArmorMod(), item.getStats().getFlatAttackSpeedMod(), item.getStats().getFlatBlockMod(), item.getStats().getFlatCritChanceMod(), item.getStats().getFlatCritDamageMod(), item.getStats().getFlatEXPBonus(), item.getStats().getFlatEnergyPoolMod(), item.getStats().getFlatEnergyRegenMod(), item.getStats().getFlatHPPoolMod(), item.getStats().getFlatHPRegenMod(), item.getStats().getFlatMPPoolMod(), item.getStats().getFlatMPRegenMod(), item.getStats().getFlatMagicDamageMod(), item.getStats().getFlatMovementSpeedMod(), item.getStats().getFlatPhysicalDamageMod(), item.getStats().getFlatSpellBlockMod(), item.getStats().getPercentArmorMod(), item.getStats().getPercentAttackSpeedMod(), item.getStats().getPercentBlockMod(), item.getStats().getPercentCritChanceMod(), item.getStats().getPercentCritDamageMod(), item.getStats().getPercentDodgeMod(), item.getStats().getPercentEXPBonus(), item.getStats().getPercentHPPoolMod(), item.getStats().getPercentHPRegenMod(), item.getStats().getPercentLifeStealMod(), item.getStats().getPercentMPPoolMod(), item.getStats().getPercentMPRegenMod(), item.getStats().getPercentMagicDamageMod(), item.getStats().getPercentMovementSpeedMod(), item.getStats().getPercentPhysicalDamageMod(), item.getStats().getPercentSpellBlockMod(), item.getStats().getPercentSpellVampMod(), item.getStats().getRFlatArmorModPerLevel(), item.getStats().getRFlatArmorPenetrationMod(), item.getStats().getRFlatArmorPenetrationModPerLevel(), item.getStats().getRFlatCritChanceModPerLevel(), item.getStats().getRFlatCritDamageModPerLevel(), item.getStats().getRFlatDodgeMod(), item.getStats().getRFlatDodgeModPerLevel(), item.getStats().getRFlatEnergyModPerLevel(), item.getStats().getRFlatEnergyRegenModPerLevel(), item.getStats().getRFlatGoldPer10Mod(), item.getStats().getRFlatHPModPerLevel(), item.getStats().getRFlatHPRegenModPerLevel(), item.getStats().getRFlatMPModPerLevel(), item.getStats().getRFlatMPRegenModPerLevel(), item.getStats().getRFlatMagicDamageModPerLevel(), item.getStats().getRFlatMagicPenetrationMod(), item.getStats().getRFlatMagicPenetrationModPerLevel(), item.getStats().getRFlatMovementSpeedModPerLevel(), item.getStats().getRFlatPhysicalDamageModPerLevel(), item.getStats().getRFlatSpellBlockModPerLevel(), item.getStats().getRFlatTimeDeadMod(), item.getStats().getRFlatTimeDeadModPerLevel(), item.getStats().getRPercentArmorPenetrationMod(), item.getStats().getRPercentArmorPenetrationModPerLevel(), item.getStats().getRPercentAttackSpeedModPerLevel(), item.getStats().getRPercentCooldownMod(), item.getStats().getRPercentCooldownModPerLevel(), item.getStats().getRPercentMagicPenetrationMod(), item.getStats().getRPercentMagicPenetrationModPerLevel(), item.getStats().getRPercentMovementSpeedModPerLevel(), item.getStats().getRPercentTimeDeadMod(), item.getStats().getRPercentTimeDeadModPerLevel());
			itemdao.save(items);
			} catch (Exception e) {
				System.out.println(item.getID());
			}
		}
		return null;
	}

	@Override
	public List<Item> findByNameIgnoreCaseContaining(String name) {
		// TODO Auto-generated method stub
		return itemdao.findByNameIgnoreCaseContaining(name);
	}

	@Override
	public Item findByItemId(int id) {
		// TODO Auto-generated method stub
		return itemdao.findByItemId(id);
	}


	


	
}
