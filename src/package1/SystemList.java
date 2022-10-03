package package1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class SystemList {
	
	public File input;
	public File output;
	public ArrayList <Sustav> system = new ArrayList<Sustav>();
	Boolean bool = true;
	
	public void loadJSON(String in) throws IOException {
		
		input = new File(in);		
		BufferedReader br = new BufferedReader(new FileReader(input));
		String str = new String();
		
		str = br.readLine();
		if(str.contentEquals("[")) {
			
			do {
				str = br.readLine();
				
				if(str.contentEquals("    {")) {
					Sustav s = new Sustav();
					
					do {
						str = br.readLine();
//						System.out.println(str + " -begin");
						if(str.contains("_id")) {
							s.iD = str.substring(16, str.length()-2);
							continue;
						}
						if(str.contains("type")) {
							s.type = str.substring(17, str.length()-2);
							continue;
						}
						if(str.contains("locationId")) {
							s.locationID = str.substring(23, str.length()-2);
							continue;
						}
						if(str.contains("configuration")) {
							do {
								str = br.readLine();
//								System.out.println(str + " -config");
								
								if(str == null) break;
								if(str.contains("general")) {
									do {
										str = br.readLine();
//										System.out.println(str + " -general");
										
										if(str.contains("room") && !str.contains("show_room")) {
											s.configuration.general.room = str.substring(25, str.length()-2);
											continue;
										}
										if(str.contains("logo")) {
											s.configuration.general.logo = str.substring(25, str.length()-2);
											continue;
										}
										if(str.contains("background")) {
											s.configuration.general.background = str.substring(31, str.length()-2);
											continue;
										}
										if(str.contains("color_theme")) {
											s.configuration.general.colorTheme = str.substring(32, str.length()-2);
											continue;
										}
										if(str.contains("title")) {
											s.configuration.general.title = str.substring(26, str.length()-2);
											continue;
										}
										
										if(str.contains("comm")) {
											s.configuration.general.comm = str.substring(25, str.length()-2);
											continue;
										}
										if(str.contains("lang")) {
											s.configuration.general.lang = str.substring(25, str.length()-2);
											continue;
										}
										if(str.contains("show_lights")) {
											if(str.contains("true")) s.configuration.general.showLights = true;
											else s.configuration.general.showLights = false;
											continue;
										}
										if(str.contains("show_hvac")) {
											if(str.contains("true")) s.configuration.general.showHvac = true;
											else s.configuration.general.showHvac = false;
											continue;
										}
										if(str.contains("show_blinds")) {
											if(str.contains("true")) s.configuration.general.showBlinds = true;
											else s.configuration.general.showBlinds = false;
											continue;
										}
										if(str.contains("show_room")) {
											if(str.contains("true")) s.configuration.general.showRoom = true;
											else s.configuration.general.showRoom = false;
											continue;
										}
										if(str.contains("show_dashboard")) {
											if(str.contains("true")) s.configuration.general.showDashboard = true;
											else s.configuration.general.showDashboard = false;
											continue;
										}
										if(str.contains("dev_mode")) {
											if(str.contains("true")) s.configuration.general.devMode = true;
											else s.configuration.general.devMode = false;
											continue;
										}
										if(str.contains("lockMobileInPortrait")) {
											if(str.contains("true")) s.configuration.general.lockMobileInPortrait = true;
											else s.configuration.general.lockMobileInPortrait = false;
											continue;
										}
										if(str.contains("lockTabletInLandscape")) {
											if(str.contains("true")) s.configuration.general.lockTabletInLandscape = true;
											else s.configuration.general.lockTabletInLandscape = false;
											continue;
										}
									} while (!str.contentEquals("            },"));
									
								}
								if(str.contains("dashboard")) {
									do {				
										str = br.readLine();
//										System.out.println(str + " -dashb");
										
										
										if(str.contains("cell1")) {
											do {
												str = br.readLine();

												if(str.contains("type")) s.configuration.dashboard.cell1.type = str.substring(29, str.length()-2);
												if(str.contains("data")) {
													str = str.substring(29, str.length()-1);
													str = str.replace("\"", "");
													s.configuration.dashboard.cell1.data = str;
												}
												if(str.contains("title")) s.configuration.dashboard.cell1.title = str.substring(30, str.length()-1);
											} while (!str.contains("                },"));
											continue;
										}
										if(str.contains("cell2")) {
											do {
												str = br.readLine();
												
												if(str.contains("type")) s.configuration.dashboard.cell2.type = str.substring(29, str.length()-2);
												if(str.contains("data")) {
													str = str.substring(29, str.length()-1);
													str = str.replace("\"", "");
													s.configuration.dashboard.cell2.data = str;
												}
												if(str.contains("title")) s.configuration.dashboard.cell2.title = str.substring(30, str.length()-1);
											} while (!str.contains("                },"));
											continue;
										}
										if(str.contains("cell3")) {
											do {
												str = br.readLine();
												
												if(str.contains("type")) s.configuration.dashboard.cell3.type = str.substring(29, str.length()-2);
												if(str.contains("data")) {
													str = str.substring(29, str.length()-1);
													str = str.replace("\"", "");
													s.configuration.dashboard.cell3.data = str;
												}
												if(str.contains("title")) s.configuration.dashboard.cell3.title = str.substring(30, str.length()-1);
											} while (!str.contains("                },"));
											continue;
										}
										if(str.contains("cell4")) {
											do {
												str = br.readLine();
												
												if(str.contains("type")) s.configuration.dashboard.cell4.type = str.substring(29, str.length()-2);
												if(str.contains("data")) {
													str = str.substring(29, str.length()-1);
													str = str.replace("\"", "");
													s.configuration.dashboard.cell4.data = str;
												}
												if(str.contains("title")) s.configuration.dashboard.cell4.title = str.substring(30, str.length()-1);
											} while (!str.contains("                },"));
											continue;
										}
										if(str.contains("cell5")) {
											do {
												str = br.readLine();
												
												if(str.contains("type")) s.configuration.dashboard.cell5.type = str.substring(29, str.length()-2);
												if(str.contains("data")) {
													str = str.substring(29, str.length()-1);
													str = str.replace("\"", "");
													s.configuration.dashboard.cell5.data = str;
												}
												if(str.contains("title")) s.configuration.dashboard.cell5.title = str.substring(30, str.length()-1);
											} while (!str.contains("                },"));
											continue;
										}
										if(str.contains("cell6")) {
											do {
												str = br.readLine();
												
												if(str.contains("type")) s.configuration.dashboard.cell6.type = str.substring(29, str.length()-2);
												if(str.contains("data")) {
													str = str.substring(29, str.length()-1);
													str = str.replace("\"", "");
													s.configuration.dashboard.cell6.data = str;
												}
												if(str.contains("title")) s.configuration.dashboard.cell6.title = str.substring(30, str.length()-1);
											} while (!str.contains("                }"));
											continue;
										}
									} while (!str.contentEquals("            },"));
								}
								if(str.contains("\"lights\"")) {
									
									do {
										str = br.readLine();
										if(str.contains("]")) break;
										
										Lights l = new Lights();
//										System.out.println("newlight");
										
										do {
											str = br.readLine();
//											System.out.println(str);
											
											if(str.contains("\"id\"")) {
												l.ID = Integer.parseInt(str.substring(27, str.length()-2));
//												System.out.println(1);
											}
											if(str.contains("\"show\"")) {
												if(str.contains("true")) l.show = true;
												else l.show = false;
//												System.out.println(2);
											}
											if(str.contains("\"text\"")) {
												l.text = str.substring(29, str.length()-2);
//												System.out.println(3);
											}
											if(str.contains("\"iconOn\"")) {
												l.iconOn = str.substring(31, str.length()-2);
//												System.out.println(4);
											}
											if(str.contains("\"iconOff\"")) {
												l.iconOff = str.substring(32, str.length()-2);
//												System.out.println(5);
											}
											if(str.contains("\"dimmable\"")) {
												if(str.contains("true")) l.dimmable = true;
												else l.dimmable = false;
//												System.out.println(6);
											}
											if(str.contains("\"control\"")) {
												l.control = str.substring(32, str.length()-2);
//												System.out.println(7);
											}	
											if(str.contains("\"status\"")) {
												l.status = str.substring(31, str.length()-1);
//												System.out.println(8);
											}						
										} while (!str.contains("}"));
										
										s.configuration.light.add(l);
//										System.out.println("ckeck");

									} while (true);
								}
								if(str.contains("hvac")) {
									do {
										str = br.readLine();
//										System.out.println(str+" -hvac");
										if(str.contentEquals("                },")) break;
										if(str.contentEquals("                \"temp_set\": {")) {
											do {
												str = br.readLine();
//												System.out.println(str + " -tempset");
												if(str.contains("show")) {
													if(str.contains("true")) {
														s.configuration.hvac.tempSet.show = true;
													}
													else s.configuration.hvac.tempSet.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.tempSet.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.tempSet.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.tempSet.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.tempSet.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.tempSet.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.tempSet.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
										
										if(str.contentEquals("                \"temp_set_plus\": {")) {
											do {
												str = br.readLine();
//												System.out.println(str + " -tempsetplus");
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.hvac.tempSetPlus.show = true;
													else s.configuration.hvac.tempSetPlus.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.tempSetPlus.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.tempSetPlus.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.tempSetPlus.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.tempSetPlus.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.tempSetPlus.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.tempSetPlus.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
										if(str.contentEquals("                \"temp_set_minus\": {")) {
											
											do {
												str = br.readLine();
//												System.out.println(str + " -tempsetminus");
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.hvac.tempSetMinus.show = true;
													else s.configuration.hvac.tempSetMinus.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.tempSetMinus.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.tempSetMinus.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.tempSetMinus.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.tempSetMinus.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.tempSetMinus.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.tempSetMinus.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
										if(str.contentEquals("                \"temp_meas\": {")) {
											
											do {
												str = br.readLine();
//												System.out.println(str+" -tempmeas");
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.hvac.tempMeas.show = true;
													else s.configuration.hvac.tempMeas.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.tempMeas.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.tempMeas.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.tempMeas.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.tempMeas.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.tempMeas.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.tempMeas.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
										if(str.contentEquals("                \"control_off\": {")) {
											
											do {
												str = br.readLine();
//												System.out.println(str+" -controloff");
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.hvac.controlOff.show = true;
													else s.configuration.hvac.controlOff.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.controlOff.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.controlOff.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.controlOff.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.controlOff.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.controlOff.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.controlOff.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
										if(str.contentEquals("                \"control_low\": {")) {
											
											do {
												str = br.readLine();
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.hvac.controlLow.show = true;
													else s.configuration.hvac.controlLow.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.controlLow.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.controlLow.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.controlLow.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.controlLow.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.controlLow.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.controlLow.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
										if(str.contentEquals("                \"control_mid\": {")) {
											
											do {
												str = br.readLine();
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.hvac.controlMid.show = true;
													else s.configuration.hvac.controlMid.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.controlMid.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.controlMid.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.controlMid.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.controlMid.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.controlMid.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.controlMid.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
										if(str.contentEquals("                \"control_high\": {")) {
											
											do {
												str = br.readLine();
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.hvac.controlHigh.show = true;
													else s.configuration.hvac.controlHigh.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.controlHigh.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.controlHigh.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.controlHigh.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.controlHigh.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.controlHigh.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.controlHigh.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
										if(str.contentEquals("                \"control_auto\": {")) {

											do {
												str = br.readLine();
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.hvac.controlAuto.show = true;
													else s.configuration.hvac.controlAuto.show = false;
												}
												if(str.contains("control")) s.configuration.hvac.controlAuto.control = str.substring(32, str.length()-2);
												if(str.contains("unit")) s.configuration.hvac.controlAuto.unit = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.hvac.controlAuto.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.hvac.controlAuto.iconOff = str.substring(32, str.length()-2);
												if(str.contains("text")) s.configuration.hvac.controlAuto.text = str.substring(29, str.length()-2);
												if(str.contains("status")) s.configuration.hvac.controlAuto.status = str.substring(31, str.length()-1);
											} while (!str.contains("}"));
										}
									} while (!str.contentEquals("            },"));		//hvac do
								}

								if(str.contains("blinds")) {
									
									do {
										if(str.contentEquals("            \"blinds\": [],")) break;
										str = br.readLine();
										
//										System.out.println("Blinds:"+str);
										if(str.contentEquals("                {")) {
											Blinds b = new Blinds();
											do {
												str = br.readLine();
//												System.out.println("Blinds do:" +str);
												
												if(str.contains("id")) b.ID = str.substring(27, str.length()-2);
												if(str.contains("name")) b.name = str.substring(29, str.length()-2);
												if(str.contains("show")) {
													if(str.contains("true")) b.show = true;
													else b.show = false;
												}
												if(str.contains("direction1")) {
													do {
														str = br.readLine();
//														System.out.println("dir1:"+str);
														
														if(str.contains("show")) {
															if(str.contains("true")) b.direction1.show = true;
															else b.direction1.show = false;
														}
														if(str.contains("text")) b.direction1.text = str.substring(33, str.length()-2);
														if(str.contains("iconOn")) b.direction1.iconOn = str.substring(35, str.length()-2);
														if(str.contains("iconOff")) b.direction1.iconOff = str.substring(36, str.length()-2);
														if(str.contains("control")) b.direction1.control = str.substring(36, str.length()-2);
														if(str.contains("status")) b.direction1.status = str.substring(35, str.length()-1);
														
													} while (!str.contains("                    },"));	//do direction1
												}
												if(str.contains("direction2")) {
													do {
														str = br.readLine();
//														System.out.println("dir2:"+str);
														
														if(str.contains("show")) {
															if(str.contains("true")) b.direction2.show = true;
															else b.direction2.show = false;
														}
														if(str.contains("text")) b.direction2.text = str.substring(33, str.length()-2);
														if(str.contains("iconOn")) b.direction2.iconOn = str.substring(35, str.length()-2);
														if(str.contains("iconOff")) b.direction2.iconOff = str.substring(36, str.length()-2);
														if(str.contains("control")) b.direction2.control = str.substring(36, str.length()-2);
														if(str.contains("status")) b.direction2.status = str.substring(35, str.length()-1);
														
													} while (!str.contains("                    }"));	//do direction2
												}
											} while (!str.contentEquals("                },") && !str.contentEquals("                }"));	//do jednog blinda
											s.configuration.blinds.add(b);
										}
									} while (!str.contentEquals("            ],"));			//do koji ucitava polje blindova
								}
								if(str.contains("room")) {
									do {
										str = br.readLine();
//										System.out.println(str+" -room");
										if(str.contains("validFrom")) s.configuration.room.validFrom = str.substring(30, str.length()-2);
										if(str.contains("validTo")) s.configuration.room.validTo = str.substring(28, str.length()-2);
										if(str.contains("digital_key")) {
											do {
												str = br.readLine();
												if(str.contains("id")) s.configuration.room.digitalKey.ID = str.substring(27, str.length()-2);
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.room.digitalKey.show = true;
													else s.configuration.room.digitalKey.show = false;
												}
												if(str.contains("text")) s.configuration.room.digitalKey.text = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.room.digitalKey.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.room.digitalKey.iconOff = str.substring(32, str.length()-2);
												if(str.contains("control")) s.configuration.room.digitalKey.control = str.substring(32, str.length()-2);
												if(str.contains("status")) s.configuration.room.digitalKey.status = str.substring(31, str.length()-1);
											}  while (!str.contentEquals("                },"));		//digital_key do
										}
										if(str.contains("dnd")) {
											do {
												str = br.readLine();
												if(str.contains("id")) s.configuration.room.dnd.ID = str.substring(27, str.length()-2);
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.room.dnd.show = true;
													else s.configuration.room.dnd.show = false;
												}
												if(str.contains("text")) s.configuration.room.dnd.text = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.room.dnd.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.room.dnd.iconOff = str.substring(32, str.length()-2);
												if(str.contains("control")) s.configuration.room.dnd.control = str.substring(32, str.length()-2);
												if(str.contains("status")) s.configuration.room.dnd.status = str.substring(31, str.length()-1);
											}  while (!str.contentEquals("                },"));		//dnd do
										}
										if(str.contains("sos")) {
											do {
												str = br.readLine();
												if(str.contains("id")) s.configuration.room.sos.ID = str.substring(27, str.length()-2);
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.room.sos.show = true;
													else s.configuration.room.sos.show = false;
												}
												if(str.contains("text")) s.configuration.room.sos.text = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.room.sos.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.room.sos.iconOff = str.substring(32, str.length()-2);
												if(str.contains("control")) s.configuration.room.sos.control = str.substring(32, str.length()-2);
												if(str.contains("status")) s.configuration.room.sos.status = str.substring(31, str.length()-1);
											}  while (!str.contentEquals("                },"));		//sos do
										}
										if(str.contains("mur")) {
											do {
												str = br.readLine();
												if(str.contains("id")) s.configuration.room.mur.ID = str.substring(27, str.length()-2);
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.room.mur.show = true;
													else s.configuration.room.mur.show = false;
												}
												if(str.contains("text")) s.configuration.room.mur.text = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.room.mur.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.room.mur.iconOff = str.substring(32, str.length()-2);
												if(str.contains("control")) s.configuration.room.mur.control = str.substring(32, str.length()-2);
												if(str.contains("status")) s.configuration.room.mur.status = str.substring(31, str.length()-1);
											}  while (!str.contentEquals("                },"));		//mur do
										}
										if(str.contains("wakeup")) {
											do {
												str = br.readLine();
												if(str.contains("id")) s.configuration.room.wakeup.ID = str.substring(27, str.length()-2);
												if(str.contains("show")) {
													if(str.contains("true")) s.configuration.room.wakeup.show = true;
													else s.configuration.room.wakeup.show = false;
												}
												if(str.contains("text")) s.configuration.room.wakeup.text = str.substring(29, str.length()-2);
												if(str.contains("iconOn")) s.configuration.room.wakeup.iconOn = str.substring(31, str.length()-2);
												if(str.contains("iconOff")) s.configuration.room.wakeup.iconOff = str.substring(32, str.length()-2);
												if(str.contains("control")) s.configuration.room.wakeup.control = str.substring(32, str.length()-2);
												if(str.contains("status")) s.configuration.room.wakeup.status = str.substring(31, str.length()-1);
											}  while (!str.contentEquals("                }"));		//wakeup do
										}
										
									} while (!str.contentEquals("            }"));		//room do
								}	
								
							} while (!str.contentEquals("        }"));			//configuration do+
							
							
						}
						
						
					} while (!str.contentEquals("    },") && !str.contentEquals("    }") && str != null);
					system.add(s);
				}
				
			} while (!str.contentEquals("]") );//first/sustav do
		}
		
		br.close();
		bool = true;
	}//load()
	
	public void writeJSON(String out) throws IOException {
		
		output = new File(out);		
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		
		bw.append("[");
		bw.newLine();
		
		for(Sustav s : system) {
			bw.append("    {");
			bw.newLine();
			{
				bw.append("        \"_id\": \"" + s.iD + "\",");
				bw.newLine();
				bw.append("        \"type\": \"" + s.type + "\",");
				bw.newLine();
				bw.append("        \"locationId\": \"" + s.locationID + "\",");
				bw.newLine();
				bw.append("        \"configuration\": {");
				bw.newLine();
				{
					bw.append("            \"general\": {");
					bw.newLine();
					{
						bw.append("                \"room\": \"" + s.configuration.general.room + "\",");
						bw.newLine();
						bw.append("                \"logo\": \"" + s.configuration.general.logo + "\",");
						bw.newLine();
						bw.append("                \"background\": \"" + s.configuration.general.background + "\",");
						bw.newLine();
						bw.append("                \"color_theme\": \"" + s.configuration.general.colorTheme + "\",");
						bw.newLine();
						bw.append("                \"title\": \"" + s.configuration.general.title + "\",");
						bw.newLine();
						bw.append("                \"comm\": \"" + s.configuration.general.comm + "\",");
						bw.newLine();
						bw.append("                \"lang\": \"" + s.configuration.general.lang + "\",");
						bw.newLine();
						bw.append("                \"show_lights\": " + s.configuration.general.showLights + ",");
						bw.newLine();
						bw.append("                \"show_hvac\": " + s.configuration.general.showHvac + ",");
						bw.newLine();
						bw.append("                \"show_blinds\": " + s.configuration.general.showBlinds + ",");
						bw.newLine();
						bw.append("                \"show_room\": " + s.configuration.general.showRoom + ",");
						bw.newLine();
						bw.append("                \"show_dashboard\": " + s.configuration.general.showDashboard + ",");
						bw.newLine();
						bw.append("                \"dev_mode\": " + s.configuration.general.devMode + ",");
						bw.newLine();
						bw.append("                \"lockMobileInPortrait\": " + s.configuration.general.lockMobileInPortrait + ",");
						bw.newLine();
						bw.append("                \"lockTabletInLandscape\": " + s.configuration.general.lockTabletInLandscape);
						bw.newLine();
					}
					bw.append("            },");
					bw.newLine();
					
					bw.append("            \"dashboard\": {");
					bw.newLine();
					{
						bw.append("                \"cell1\": {");
						bw.newLine();
							bw.append("                    \"type\": \"" + s.configuration.dashboard.cell1.type + "\",");
							bw.newLine();
							bw.append("                    \"data\": \"" + s.configuration.dashboard.cell1.data + "\"");
							if(s.configuration.dashboard.cell1.title != null) {
								bw.append(",");
								bw.newLine();
								bw.append("                    \"title\": \"" + s.configuration.dashboard.cell1.title + "\"");
							}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						bw.append("                \"cell2\": {");
						bw.newLine();
							bw.append("                    \"type\": \"" + s.configuration.dashboard.cell2.type + "\",");
							bw.newLine();
							bw.append("                    \"data\": \"" + s.configuration.dashboard.cell2.data + "\"");
							if(s.configuration.dashboard.cell2.title != null) {
								bw.append(",");
								bw.newLine();
								bw.append("                    \"title\": \"" + s.configuration.dashboard.cell2.title + "\"");
							}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						bw.append("                \"cell3\": {");
						bw.newLine();
							bw.append("                    \"type\": \"" + s.configuration.dashboard.cell3.type + "\",");
							bw.newLine();
							bw.append("                    \"data\": \"" + s.configuration.dashboard.cell3.data + "\"");
							if(s.configuration.dashboard.cell3.title != null) {
								bw.append(",");
								bw.newLine();
								bw.append("                    \"title\": \"" + s.configuration.dashboard.cell3.title + "\"");
							}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						bw.append("                \"cell4\": {");
						bw.newLine();
							bw.append("                    \"type\": \"" + s.configuration.dashboard.cell4.type + "\",");
							bw.newLine();
							bw.append("                    \"data\": \"" + s.configuration.dashboard.cell4.data + "\"");
							if(s.configuration.dashboard.cell4.title != null) {
								bw.append(",");
								bw.newLine();
								bw.append("                    \"title\": \"" + s.configuration.dashboard.cell4.title + "\"");
							}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						bw.append("                \"cell5\": {");
						bw.newLine();
							bw.append("                    \"type\": \"" + s.configuration.dashboard.cell5.type + "\",");
							bw.newLine();
							bw.append("                    \"data\": \"" + s.configuration.dashboard.cell5.data + "\"");
							if(s.configuration.dashboard.cell5.title != null) {
								bw.append(",");
								bw.newLine();
								bw.append("                    \"title\": \"" + s.configuration.dashboard.cell5.title + "\"");
							}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						bw.append("                \"cell6\": {");
						bw.newLine();
							bw.append("                    \"type\": \"" + s.configuration.dashboard.cell6.type + "\",");
							bw.newLine();
							bw.append("                    \"data\": \"" + s.configuration.dashboard.cell6.data + "\"");
							if(s.configuration.dashboard.cell6.title != null) {
								bw.append(",");
								bw.newLine();
								bw.append("                    \"title\": \"" + s.configuration.dashboard.cell6.title + "\"");
							}
							bw.newLine();
						bw.append("                }");
						bw.newLine();
					}
					bw.append("            },");
					bw.newLine();
						
					bw.append("            \"lights\": [");
					bw.newLine();
					{
						for(int i = 0; i < s.configuration.light.size(); i++) {
							bw.append("                {");
							bw.newLine();
								bw.append("                    \"id\": \"" + s.configuration.light.get(i).ID + "\",");
								bw.newLine();
								bw.append("                    \"show\": " + s.configuration.light.get(i).show + ",");
								bw.newLine();
								bw.append("                    \"text\": \"" + s.configuration.light.get(i).text + "\",");
								bw.newLine();
								bw.append("                    \"iconOn\": \"" + s.configuration.light.get(i).iconOn + "\",");
								bw.newLine();
								bw.append("                    \"iconOff\": \"" + s.configuration.light.get(i).iconOff + "\",");
								bw.newLine();
								bw.append("                    \"dimmable\": " + s.configuration.light.get(i).dimmable + ",");
								bw.newLine();
								bw.append("                    \"control\": \"" + s.configuration.light.get(i).control + "\",");
								bw.newLine();
								bw.append("                    \"status\": \"" + s.configuration.light.get(i).status + "\"");
								bw.newLine();
							bw.append("                }");
							if(i < s.configuration.light.size()-1) bw.append(","); 
							bw.newLine();
						}
					}
					bw.append("            ],");
					bw.newLine();
					
					bw.append("            \"hvac\": {");
					bw.newLine();
					{
						bw.append("                \"temp_set\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.tempSet.show);
							if(s.configuration.hvac.tempSet.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.tempSet.control + "\"");}
							if(s.configuration.hvac.tempSet.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.tempSet.unit + "\"");}
							if(s.configuration.hvac.tempSet.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.tempSet.iconOn + "\"");}
							if(s.configuration.hvac.tempSet.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.tempSet.iconOff + "\"");}
							if(s.configuration.hvac.tempSet.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.tempSet.text + "\"");}
							if(s.configuration.hvac.tempSet.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.tempSet.status + "\"");}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"temp_set_plus\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.tempSetPlus.show);
							if(s.configuration.hvac.tempSetPlus.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.tempSetPlus.control + "\"");}
							if(s.configuration.hvac.tempSetPlus.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.tempSetPlus.unit + "\"");}
							if(s.configuration.hvac.tempSetPlus.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.tempSetPlus.iconOn + "\"");}
							if(s.configuration.hvac.tempSetPlus.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.tempSetPlus.iconOff + "\"");}
							if(s.configuration.hvac.tempSetPlus.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.tempSetPlus.text + "\"");}
							if(s.configuration.hvac.tempSetPlus.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.tempSetPlus.status + "\"");}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"temp_set_minus\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.tempSetMinus.show);
							if(s.configuration.hvac.tempSetMinus.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.tempSetMinus.control + "\"");}
							if(s.configuration.hvac.tempSetMinus.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.tempSetMinus.unit + "\"");}
							if(s.configuration.hvac.tempSetMinus.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.tempSetMinus.iconOn + "\"");}
							if(s.configuration.hvac.tempSetMinus.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.tempSetMinus.iconOff + "\"");}
							if(s.configuration.hvac.tempSetMinus.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.tempSetMinus.text + "\"");}
							if(s.configuration.hvac.tempSetMinus.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.tempSetMinus.status + "\"");}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"temp_meas\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.tempMeas.show);
							if(s.configuration.hvac.tempMeas.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.tempMeas.control + "\"");}
							if(s.configuration.hvac.tempMeas.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.tempMeas.unit + "\"");}
							if(s.configuration.hvac.tempMeas.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.tempMeas.iconOn + "\"");}
							if(s.configuration.hvac.tempMeas.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.tempMeas.iconOff + "\"");}
							if(s.configuration.hvac.tempMeas.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.tempMeas.text + "\"");}
							if(s.configuration.hvac.tempMeas.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.tempMeas.status + "\"");}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"control_off\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.controlOff.show);
							if(s.configuration.hvac.controlOff.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.controlOff.unit + "\"");}
							if(s.configuration.hvac.controlOff.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.controlOff.iconOn + "\"");}
							if(s.configuration.hvac.controlOff.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.controlOff.iconOff + "\"");}
							if(s.configuration.hvac.controlOff.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.controlOff.control + "\"");}
							if(s.configuration.hvac.controlOff.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.controlOff.text + "\"");}
							if(s.configuration.hvac.controlOff.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.controlOff.status + "\"");}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"control_low\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.controlLow.show);
							if(s.configuration.hvac.controlLow.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.controlLow.unit + "\"");}
							if(s.configuration.hvac.controlLow.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.controlLow.iconOn + "\"");}
							if(s.configuration.hvac.controlLow.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.controlLow.iconOff + "\"");}
							if(s.configuration.hvac.controlLow.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.controlLow.control + "\"");}
							if(s.configuration.hvac.controlLow.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.controlLow.text + "\"");}
							if(s.configuration.hvac.controlLow.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.controlLow.status + "\"");}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"control_mid\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.controlMid.show);
							if(s.configuration.hvac.controlMid.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.controlMid.unit + "\"");}
							if(s.configuration.hvac.controlMid.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.controlMid.iconOn + "\"");}
							if(s.configuration.hvac.controlMid.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.controlMid.iconOff + "\"");}
							if(s.configuration.hvac.controlMid.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.controlMid.control + "\"");}
							if(s.configuration.hvac.controlMid.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.controlMid.text + "\"");}
							if(s.configuration.hvac.controlMid.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.controlMid.status + "\"");}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"control_high\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.controlHigh.show);
							if(s.configuration.hvac.controlHigh.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.controlHigh.unit + "\"");}
							if(s.configuration.hvac.controlHigh.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.controlHigh.iconOn + "\"");}
							if(s.configuration.hvac.controlHigh.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.controlHigh.iconOff + "\"");}
							if(s.configuration.hvac.controlHigh.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.controlHigh.control + "\"");}
							if(s.configuration.hvac.controlHigh.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.controlHigh.text + "\"");}
							if(s.configuration.hvac.controlHigh.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.controlHigh.status + "\"");}
							bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"control_auto\": {");
						bw.newLine();
							bw.append("                    \"show\": " + s.configuration.hvac.controlAuto.show);
							if(s.configuration.hvac.controlAuto.unit != null) {bw.append(","); bw.newLine(); bw.append("                    \"unit\": \"" + s.configuration.hvac.controlAuto.unit + "\"");}
							if(s.configuration.hvac.controlAuto.iconOn != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOn\": \"" + s.configuration.hvac.controlAuto.iconOn + "\"");}
							if(s.configuration.hvac.controlAuto.iconOff != null) {bw.append(","); bw.newLine(); bw.append("                    \"iconOff\": \"" + s.configuration.hvac.controlAuto.iconOff + "\"");}
							if(s.configuration.hvac.controlAuto.control != null) {bw.append(","); bw.newLine(); bw.append("                    \"control\": \"" + s.configuration.hvac.controlAuto.control + "\"");}
							if(s.configuration.hvac.controlAuto.text != null) {bw.append(","); bw.newLine(); bw.append("                    \"text\": \"" + s.configuration.hvac.controlAuto.text + "\"");}
							if(s.configuration.hvac.controlAuto.status != null) {bw.append(","); bw.newLine(); bw.append("                    \"status\": \"" + s.configuration.hvac.controlAuto.status + "\"");}
							bw.newLine();
						bw.append("                }");
						bw.newLine();
					}
					bw.append("            },");
					bw.newLine();
					
					bw.append("            \"blinds\": [");
					{
						if(!s.configuration.blinds.isEmpty()) {
							for(int i = 0; i < s.configuration.blinds.size(); i++) {
								bw.newLine();
								bw.append("                {");
								bw.newLine();
								bw.append("                    \"id\": \"" + s.configuration.blinds.get(i).ID + "\",");
								bw.newLine();
								bw.append("                    \"name\": \"" + s.configuration.blinds.get(i).name + "\",");
								bw.newLine();
								bw.append("                    \"show\": " + s.configuration.blinds.get(i).show + ",");
								bw.newLine();
								bw.append("                    \"direction1\": {");
								bw.newLine();
								bw.append("                        \"show\": " + s.configuration.blinds.get(i).direction1.show + ",");
								bw.newLine();
								bw.append("                        \"text\": \"" + s.configuration.blinds.get(i).direction1.text + "\",");
								bw.newLine();
								bw.append("                        \"iconOn\": \"" + s.configuration.blinds.get(i).direction1.iconOn + "\",");
								bw.newLine();
								bw.append("                        \"iconOff\": \"" + s.configuration.blinds.get(i).direction1.iconOff + "\",");
								bw.newLine();
								bw.append("                        \"control\": \"" + s.configuration.blinds.get(i).direction1.control + "\",");
								bw.newLine();
								bw.append("                        \"status\": \"" + s.configuration.blinds.get(i).direction1.status + "\"");
								bw.newLine();
								bw.append("                    },");
								bw.newLine();
								bw.append("                    \"direction2\": {");
								bw.newLine();
								bw.append("                        \"show\": " + s.configuration.blinds.get(i).direction2.show + ",");
								bw.newLine();
								bw.append("                        \"text\": \"" + s.configuration.blinds.get(i).direction2.text + "\",");
								bw.newLine();
								bw.append("                        \"iconOn\": \"" + s.configuration.blinds.get(i).direction2.iconOn + "\",");
								bw.newLine();
								bw.append("                        \"iconOff\": \"" + s.configuration.blinds.get(i).direction2.iconOff + "\",");
								bw.newLine();
								bw.append("                        \"control\": \"" + s.configuration.blinds.get(i).direction2.control + "\",");
								bw.newLine();
								bw.append("                        \"status\": \"" + s.configuration.blinds.get(i).direction2.status + "\"");
								bw.newLine();
								bw.append("                    }");
								bw.newLine();
								bw.append("                }");
								if(i < s.configuration.blinds.size()-1) bw.append(",");
							}
							bw.newLine();
							bw.append("            ");
						}
						
						bw.append("],");					
						bw.newLine();
					}
					
					
					bw.append("            \"room\": {");
					bw.newLine();
					{
						bw.append("                \"validFrom\": \"" + s.configuration.room.validFrom + "\",");
						bw.newLine();
						bw.append("                \"validTo\": \"" + s.configuration.room.validTo + "\",");
						bw.newLine();
						
						bw.append("                \"digital_key\": {");
						bw.newLine();
						bw.append("                    \"id\": \"" + s.configuration.room.digitalKey.ID + "\",");
						bw.newLine();
						bw.append("                    \"show\": " + s.configuration.room.digitalKey.show + ",");
						bw.newLine();
						bw.append("                    \"text\": \"" + s.configuration.room.digitalKey.text + "\",");
						bw.newLine();
						bw.append("                    \"iconOn\": \"" + s.configuration.room.digitalKey.iconOn + "\",");
						bw.newLine();
						bw.append("                    \"iconOff\": \"" + s.configuration.room.digitalKey.iconOff + "\",");
						bw.newLine();
						bw.append("                    \"control\": \"" + s.configuration.room.digitalKey.control + "\",");
						bw.newLine();
						bw.append("                    \"status\": \"" + s.configuration.room.digitalKey.status + "\"");
						bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"dnd\": {");
						bw.newLine();
						bw.append("                    \"id\": \"" + s.configuration.room.dnd.ID + "\",");
						bw.newLine();
						bw.append("                    \"show\": " + s.configuration.room.dnd.show + ",");
						bw.newLine();
						bw.append("                    \"text\": \"" + s.configuration.room.dnd.text + "\",");
						bw.newLine();
						bw.append("                    \"iconOn\": \"" + s.configuration.room.dnd.iconOn + "\",");
						bw.newLine();
						bw.append("                    \"iconOff\": \"" + s.configuration.room.dnd.iconOff + "\",");
						bw.newLine();
						bw.append("                    \"control\": \"" + s.configuration.room.dnd.control + "\",");
						bw.newLine();
						bw.append("                    \"status\": \"" + s.configuration.room.dnd.status + "\"");
						bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"sos\": {");
						bw.newLine();
						bw.append("                    \"id\": \"" + s.configuration.room.sos.ID + "\",");
						bw.newLine();
						bw.append("                    \"show\": " + s.configuration.room.sos.show + ",");
						bw.newLine();
						bw.append("                    \"text\": \"" + s.configuration.room.sos.text + "\",");
						bw.newLine();
						bw.append("                    \"iconOn\": \"" + s.configuration.room.sos.iconOn + "\",");
						bw.newLine();
						bw.append("                    \"iconOff\": \"" + s.configuration.room.sos.iconOff + "\",");
						bw.newLine();
						bw.append("                    \"control\": \"" + s.configuration.room.sos.control + "\",");
						bw.newLine();
						bw.append("                    \"status\": \"" + s.configuration.room.sos.status + "\"");
						bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"mur\": {");
						bw.newLine();
						bw.append("                    \"id\": \"" + s.configuration.room.mur.ID + "\",");
						bw.newLine();
						bw.append("                    \"show\": " + s.configuration.room.mur.show + ",");
						bw.newLine();
						bw.append("                    \"text\": \"" + s.configuration.room.mur.text + "\",");
						bw.newLine();
						bw.append("                    \"iconOn\": \"" + s.configuration.room.mur.iconOn + "\",");
						bw.newLine();
						bw.append("                    \"iconOff\": \"" + s.configuration.room.mur.iconOff + "\",");
						bw.newLine();
						bw.append("                    \"control\": \"" + s.configuration.room.mur.control + "\",");
						bw.newLine();
						bw.append("                    \"status\": \"" + s.configuration.room.mur.status + "\"");
						bw.newLine();
						bw.append("                },");
						bw.newLine();
						
						bw.append("                \"wakeup\": {");
						bw.newLine();
						bw.append("                    \"id\": \"" + s.configuration.room.wakeup.ID + "\",");
						bw.newLine();
						bw.append("                    \"show\": " + s.configuration.room.wakeup.show + ",");
						bw.newLine();
						bw.append("                    \"text\": \"" + s.configuration.room.wakeup.text + "\",");
						bw.newLine();
						bw.append("                    \"iconOn\": \"" + s.configuration.room.wakeup.iconOn + "\",");
						bw.newLine();
						bw.append("                    \"iconOff\": \"" + s.configuration.room.wakeup.iconOff + "\",");
						bw.newLine();
						bw.append("                    \"control\": \"" + s.configuration.room.wakeup.control + "\",");
						bw.newLine();
						bw.append("                    \"status\": \"" + s.configuration.room.wakeup.status + "\"");
						bw.newLine();
						bw.append("                }");
						bw.newLine();
					}
					bw.append("            }");
					bw.newLine();
					
				}	
				bw.append("        }");
				bw.newLine();
			}	
			bw.append("    }");
			if(s != system.get(system.size()-1)) bw.append(",");
			bw.newLine();			
		}
		
		bw.append("]");
		
		bw.close();
	}


}//SystemList

