package dndModifiers;

public class DndStats {
	private int myStat;
	private int dndMod;
	// Organizing the modifiers for rolls based on the stats provided in DndChar
	
	public DndStats (int charStat) {
		myStat = charStat;
	}
	
	public void setStat(int newStat) {
		myStat = newStat;
	}
	
	public int getStat() {
		return myStat;
	}
	// This is horribly unoptimized, if anyone has any suggestions on how to fix it please tell me i am suffering out here
	public int proficiencyRoll() {
		if (myStat < 30) {
			if (myStat < 28) {
				if (myStat < 26) {
					if (myStat < 24) {
						if (myStat < 22) {
							if (myStat < 20) {
								if (myStat < 18) {
									if (myStat < 16) {
										if (myStat < 14) {
											if (myStat < 12) {
												if (myStat < 10) {
													if (myStat < 8) {
														if (myStat < 6) {
															if (myStat < 4) {
																if (myStat < 2) {
																	if (myStat < 1) {
																		System.out.println("Error; Stat cannot be below 1");
																	}
																	else {
																		dndMod = -5;
																	}
																}
																else {
																	dndMod = -4;
																}
															}
															else {
																dndMod = -3;
															}
														}
														else {
															dndMod = -2;
														}
													}
													else {
														dndMod = -1;
													}
												}
												else {
													dndMod = 0;
												}
											}
											else {
												dndMod = 1;
											}
										}
										else {
											dndMod = 2;
										}
									}
									else {
										dndMod = 3;
									}
								}
								else {
									dndMod = 4;
								}
							}
							else {
								dndMod = 5;
							}
						}
						else {
							dndMod = 6;
						}
					}
					else {
						dndMod = 7;
					}
				}
				else {
					dndMod = 8;
				}
			}
			else {
				dndMod = 9;
			}
		}
		else {
			dndMod = 10;
		}
		return dndMod;
	}
}
