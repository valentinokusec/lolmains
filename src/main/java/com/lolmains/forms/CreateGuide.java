package com.lolmains.forms;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CreateGuide {
	
	private int main;
	
	private int guide;
	
	private int param1;
	
	private int param2;
	
	private int param3;
	
	private int param4;
	
	private int param5;
	
	private int param6;
	
	private long param7;
	
	private long param8;
	
	private int param9;
	
	private int param10;
	
	private int param11;
	
	private int param12;
	
	private int param13;
	
	private int param14;
	
	private int param15;
	
	private int param16;
	
	private int param17;
	
	private int param18;
	
	private int param19;
	
	private int param20;
	
	private int param21;
	
	private int param22;
	
	private int param23;
	
	private int param24;
	
	private int param25;
	
	private int param26;
	
	private int param27;
	
	private int param28;
	
	private int param29;
	
	private int param30;
	
	private int param31;
	
	private int param32;
	
	private int param33;
	
	private int param34;
	
	private int param35;
	
	private int param36;
	
	private int param37;
	
	private int param38;
	
	private int param39;
	
	private int param40;
	
	private int param41;
	
	private int param42;
	
	private int param43;
	
	private int param44;
	
	private int param45;
	
	private int param46;
	
	private int param47;
	
	private int param48;
	
	private int param49;
	
	private int param50;
	
	private int param51;
	
	private int param52;
	
	private int param53;
	
	private int param54;
	
	private int param55;
	
	private int param56;
	
	private int param57;
	
	private int param58;
	
	private int param59;
	
	private int param60;
	
	private int param61;
	
	private int param62;
	
	private int param63;
	
	private int param64;
	
	private int param65;
	
	private int param66;
	
	private int param67;
	
	private int param68;
	
	private int param69;
	
	private int param70;
	
	private int param71;
	
	private int param72;
	
	private int param73;
	
	private int param74;
	
	private int param75;
	
	private int param76;
	
	private int param77;
	
	private int param78;
	
	private int param79;
	
	private int param80;
	
	private int param81;
	
	private int param82;
	
	private int param83;
	
	private String param84;
	
	
	private String name;
	
	private String generalDescription;
	
	private String buildDescription;
	
	private String summonersDescription;
	
	private String masteriesDescription;
	
	private String runesDescription;
	
	private List<String> extraBuildDescription= new ArrayList<String>();
	
	private List<String> extraBuildLabel= new ArrayList<String>();
	

	ArrayList<ArrayList<Integer>> itemList = new ArrayList<ArrayList<Integer>>();
	
	private List<String> extraSummonersDescription= new ArrayList<String>();
	
	private List<String> extraSummonersLabel= new ArrayList<String>();
	
	private int[][] summonersList;
	
	private List<String> extraNotes= new ArrayList<String>();
	
	private List<String> extraNotesDescription= new ArrayList<String>();
	
	
	
	
	
	
	
	
	
	
	public List<String> getExtraBuildDescription() {
		return extraBuildDescription;
	}
	public void setExtraBuildDescription(List<String> extraBuildDescription) {
		this.extraBuildDescription = extraBuildDescription;
	}
	public List<String> getExtraBuildLabel() {
		return extraBuildLabel;
	}
	public void setExtraBuildLabel(List<String> extraBuildLabel) {
		this.extraBuildLabel = extraBuildLabel;
	}

	public ArrayList<ArrayList<Integer>> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ArrayList<Integer>> itemList) {
		this.itemList = itemList;
	}
	public List<String> getExtraSummonersDescription() {
		return extraSummonersDescription;
	}
	public void setExtraSummonersDescription(List<String> extraSummonersDescription) {
		this.extraSummonersDescription = extraSummonersDescription;
	}
	public List<String> getExtraSummonersLabel() {
		return extraSummonersLabel;
	}
	public void setExtraSummonersLabel(List<String> extraSummonersLabel) {
		this.extraSummonersLabel = extraSummonersLabel;
	}
	public int[][] getSummonersList() {
		return summonersList;
	}
	public void setSummonersList(int[][] summonersList) {
		this.summonersList = summonersList;
	}
	public List<String> getExtraNotes() {
		return extraNotes;
	}
	public void setExtraNotes(List<String> extraNotes) {
		this.extraNotes = extraNotes;
	}
	public List<String> getExtraNotesDescription() {
		return extraNotesDescription;
	}
	public void setExtraNotesDescription(List<String> extraNotesDescription) {
		this.extraNotesDescription = extraNotesDescription;
	}
	public String getSummonersDescription() {
		return summonersDescription;
	}
	public void setSummonersDescription(String summonersDescription) {
		this.summonersDescription = summonersDescription;
	}
	public String getMasteriesDescription() {
		return masteriesDescription;
	}
	public void setMasteriesDescription(String masteriesDescription) {
		this.masteriesDescription = masteriesDescription;
	}
	public int getParam12() {
		return param12;
	}
	public void setParam12(int param12) {
		this.param12 = param12;
	}
	public int getParam13() {
		return param13;
	}
	public void setParam13(int param13) {
		this.param13 = param13;
	}
	public int getParam14() {
		return param14;
	}
	public void setParam14(int param14) {
		this.param14 = param14;
	}
	public int getParam15() {
		return param15;
	}
	public void setParam15(int param15) {
		this.param15 = param15;
	}
	public int getParam16() {
		return param16;
	}
	public void setParam16(int param16) {
		this.param16 = param16;
	}
	public int getParam17() {
		return param17;
	}
	public void setParam17(int param17) {
		this.param17 = param17;
	}
	public int getParam18() {
		return param18;
	}
	public void setParam18(int param18) {
		this.param18 = param18;
	}
	public int getParam19() {
		return param19;
	}
	public void setParam19(int param19) {
		this.param19 = param19;
	}
	public int getParam20() {
		return param20;
	}
	public void setParam20(int param20) {
		this.param20 = param20;
	}
	public int getParam22() {
		return param22;
	}
	public void setParam22(int param22) {
		this.param22 = param22;
	}
	public int getParam23() {
		return param23;
	}
	public void setParam23(int param23) {
		this.param23 = param23;
	}
	public int getParam24() {
		return param24;
	}
	public void setParam24(int param24) {
		this.param24 = param24;
	}
	public int getParam25() {
		return param25;
	}
	public void setParam25(int param25) {
		this.param25 = param25;
	}
	public int getParam26() {
		return param26;
	}
	public void setParam26(int param26) {
		this.param26 = param26;
	}
	public int getParam27() {
		return param27;
	}
	public void setParam27(int param27) {
		this.param27 = param27;
	}
	public int getParam28() {
		return param28;
	}
	public void setParam28(int param28) {
		this.param28 = param28;
	}
	public int getParam29() {
		return param29;
	}
	public void setParam29(int param29) {
		this.param29 = param29;
	}
	public int getParam30() {
		return param30;
	}
	public void setParam30(int param30) {
		this.param30 = param30;
	}
	public int getParam31() {
		return param31;
	}
	public void setParam31(int param31) {
		this.param31 = param31;
	}
	public int getParam32() {
		return param32;
	}
	public void setParam32(int param32) {
		this.param32 = param32;
	}
	public int getParam33() {
		return param33;
	}
	public void setParam33(int param33) {
		this.param33 = param33;
	}
	public int getParam34() {
		return param34;
	}
	public void setParam34(int param34) {
		this.param34 = param34;
	}
	public int getParam35() {
		return param35;
	}
	public void setParam35(int param35) {
		this.param35 = param35;
	}
	public int getParam36() {
		return param36;
	}
	public void setParam36(int param36) {
		this.param36 = param36;
	}
	public int getParam37() {
		return param37;
	}
	public void setParam37(int param37) {
		this.param37 = param37;
	}
	public int getParam38() {
		return param38;
	}
	public void setParam38(int param38) {
		this.param38 = param38;
	}
	public int getParam39() {
		return param39;
	}
	public void setParam39(int param39) {
		this.param39 = param39;
	}
	public int getParam40() {
		return param40;
	}
	public void setParam40(int param40) {
		this.param40 = param40;
	}
	public int getParam41() {
		return param41;
	}
	public void setParam41(int param41) {
		this.param41 = param41;
	}
	public int getParam42() {
		return param42;
	}
	public void setParam42(int param42) {
		this.param42 = param42;
	}
	public int getParam43() {
		return param43;
	}
	public void setParam43(int param43) {
		this.param43 = param43;
	}
	public int getParam44() {
		return param44;
	}
	public void setParam44(int param44) {
		this.param44 = param44;
	}
	public int getParam45() {
		return param45;
	}
	public void setParam45(int param45) {
		this.param45 = param45;
	}
	public int getParam46() {
		return param46;
	}
	public void setParam46(int param46) {
		this.param46 = param46;
	}
	public int getParam47() {
		return param47;
	}
	public void setParam47(int param47) {
		this.param47 = param47;
	}
	public int getParam48() {
		return param48;
	}
	public void setParam48(int param48) {
		this.param48 = param48;
	}
	public int getParam49() {
		return param49;
	}
	public void setParam49(int param49) {
		this.param49 = param49;
	}
	public int getParam50() {
		return param50;
	}
	public void setParam50(int param50) {
		this.param50 = param50;
	}
	public int getParam61() {
		return param61;
	}
	public void setParam61(int param61) {
		this.param61 = param61;
	}
	public int getParam62() {
		return param62;
	}
	public void setParam62(int param62) {
		this.param62 = param62;
	}
	public int getParam63() {
		return param63;
	}
	public void setParam63(int param63) {
		this.param63 = param63;
	}
	public int getParam64() {
		return param64;
	}
	public void setParam64(int param64) {
		this.param64 = param64;
	}
	public int getParam65() {
		return param65;
	}
	public void setParam65(int param65) {
		this.param65 = param65;
	}
	public int getParam66() {
		return param66;
	}
	public void setParam66(int param66) {
		this.param66 = param66;
	}
	public int getParam67() {
		return param67;
	}
	public void setParam67(int param67) {
		this.param67 = param67;
	}
	public int getParam68() {
		return param68;
	}
	public void setParam68(int param68) {
		this.param68 = param68;
	}
	public int getParam69() {
		return param69;
	}
	public void setParam69(int param69) {
		this.param69 = param69;
	}
	public int getParam70() {
		return param70;
	}
	public void setParam70(int param70) {
		this.param70 = param70;
	}
	public int getParam71() {
		return param71;
	}
	public void setParam71(int param71) {
		this.param71 = param71;
	}
	public int getParam72() {
		return param72;
	}
	public void setParam72(int param72) {
		this.param72 = param72;
	}
	public int getParam73() {
		return param73;
	}
	public void setParam73(int param73) {
		this.param73 = param73;
	}
	public int getParam74() {
		return param74;
	}
	public void setParam74(int param74) {
		this.param74 = param74;
	}

	public int getParam1() {
		return param1;
	}
	public void setParam1(int param1) {
		this.param1 = param1;
	}
	public int getParam2() {
		return param2;
	}
	public void setParam2(int param2) {
		this.param2 = param2;
	}
	public int getParam3() {
		return param3;
	}
	public void setParam3(int param3) {
		this.param3 = param3;
	}
	public int getParam4() {
		return param4;
	}
	public void setParam4(int param4) {
		this.param4 = param4;
	}
	public int getParam5() {
		return param5;
	}
	public void setParam5(int param5) {
		this.param5 = param5;
	}
	public int getParam6() {
		return param6;
	}
	public void setParam6(int param6) {
		this.param6 = param6;
	}
	public long getParam7() {
		return param7;
	}
	public void setParam7(long param7) {
		this.param7 = param7;
	}
	public long getParam8() {
		return param8;
	}
	public void setParam8(long param8) {
		this.param8 = param8;
	}
	public int getParam10() {
		return param10;
	}
	public void setParam10(int param10) {
		this.param10 = param10;
	}
	public int getParam11() {
		return param11;
	}
	public void setParam11(int param11) {
		this.param11 = param11;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGeneralDescription() {
		return generalDescription;
	}
	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}
	public String getBuildDescription() {
		return buildDescription;
	}
	public void setBuildDescription(String buildDescription) {
		this.buildDescription = buildDescription;
	}
	public int getParam9() {
		return param9;
	}
	public void setParam9(int param9) {
		this.param9 = param9;
	}
	public String getRunesDescription() {
		return runesDescription;
	}
	public void setRunesDescription(String runesDescription) {
		this.runesDescription = runesDescription;
	}

	public int getParam21() {
		return param21;
	}
	public void setParam21(int param21) {
		this.param21 = param21;
	}
	public int getParam51() {
		return param51;
	}
	public void setParam51(int param51) {
		this.param51 = param51;
	}
	public int getParam52() {
		return param52;
	}
	public void setParam52(int param52) {
		this.param52 = param52;
	}
	public int getParam53() {
		return param53;
	}
	public void setParam53(int param53) {
		this.param53 = param53;
	}
	public int getParam54() {
		return param54;
	}
	public void setParam54(int param54) {
		this.param54 = param54;
	}
	public int getParam55() {
		return param55;
	}
	public void setParam55(int param55) {
		this.param55 = param55;
	}
	public int getParam56() {
		return param56;
	}
	public void setParam56(int param56) {
		this.param56 = param56;
	}
	public int getParam57() {
		return param57;
	}
	public void setParam57(int param57) {
		this.param57 = param57;
	}
	public int getParam58() {
		return param58;
	}
	public void setParam58(int param58) {
		this.param58 = param58;
	}
	public int getParam59() {
		return param59;
	}
	public void setParam59(int param59) {
		this.param59 = param59;
	}
	public int getParam60() {
		return param60;
	}
	public void setParam60(int param60) {
		this.param60 = param60;
	}
	public int getParam75() {
		return param75;
	}
	public void setParam75(int param75) {
		this.param75 = param75;
	}
	public int getParam76() {
		return param76;
	}
	public void setParam76(int param76) {
		this.param76 = param76;
	}
	public int getParam77() {
		return param77;
	}
	public void setParam77(int param77) {
		this.param77 = param77;
	}
	public int getParam78() {
		return param78;
	}
	public void setParam78(int param78) {
		this.param78 = param78;
	}
	public int getParam79() {
		return param79;
	}
	public void setParam79(int param79) {
		this.param79 = param79;
	}
	public int getParam80() {
		return param80;
	}
	public void setParam80(int param80) {
		this.param80 = param80;
	}
	public int getParam81() {
		return param81;
	}
	public void setParam81(int param81) {
		this.param81 = param81;
	}
	public int getParam82() {
		return param82;
	}
	public void setParam82(int param82) {
		this.param82 = param82;
	}
	public int getParam83() {
		return param83;
	}
	public void setParam83(int param83) {
		this.param83 = param83;
	}
	public String getParam84() {
		return param84;
	}
	public void setParam84(String param84) {
		this.param84 = param84;
	}
	public int getMain() {
		return main;
	}
	public void setMain(int main) {
		this.main = main;
	}
	public int getGuide() {
		return guide;
	}
	public void setGuide(int guide) {
		this.guide = guide;
	}

	
	

}
