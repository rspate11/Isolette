package Multithreading;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Isolette {
		public static void main(String[] args) throws Exception {
			float dmin;
			float dmax;
			float almin;
			float almax;
			boolean onevent = false, bStatus;
			String s = "";
			Nurse nurse = new Nurse();
			Baby baby = new Baby();
			Air air = new Air();
			Thermostat t = new Thermostat();
			HeatSource h = new HeatSource();

			TempSensor ts = new TempSensor();

		while(true) {
			try {
				System.out.println("Enter intruction for the isolette(ON/OFF): ");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				onevent = sc.nextBoolean();	
				nurse.setON(onevent);
				if (!onevent) {
					System.out.println("Isolette is turned OFF ");
					Clock c = new Clock(onevent,ts,t,nurse, baby,h);
				}
				else {

				System.out.println("Enter desired minimum temperature: ");
				dmin = sc.nextFloat();
				nurse.setDmin(dmin);
				System.out.println("Enter desired maximum temperature: ");
				dmax = sc.nextFloat();
				nurse.setDmax(dmax);
				System.out.println("Enter alarm minimum temperature: ");
				almin = sc.nextFloat();
				nurse.setAmin(almin);
				System.out.println("Enter alarm maximum temperature: ");
				almax = sc.nextFloat();
				nurse.setAmax(almax);
//				System.out.println( dmin);
//				System.out.println(onevent);

//				float h = nurse.alarmmax;
				Display d = new Display ();
				System.out.println("Thermostat is in INIT mode");
//				System.out.println(h);
				d.setStatus(nurse);
				t.setMode(d);
				//t.setcurrTemp(99);

				File inFile = new File("C:\\Users\\Riddhi\\ASU\\SD\\Project\\Isolette\\src\\Implementation\\Inputtemp.txt");
				@SuppressWarnings("resource")
				Scanner sc1 = new Scanner(inFile);
				float value = sc1.nextFloat();
				ts.setroomtemp(value);
				air.settemp(value);
				t.setcurrTemp(value);
				//t.setStatuses(nurse);
				t.setHeatSource(nurse);
				Clock c = new Clock(onevent,ts,t,nurse,baby, h);
				
				//validate inputs
				//set heat status
				//set alarm status
				//set 
				//set babystatus
//				bStatus = baby.getbStatus();
//				if (bStatus)
//				{
//					s = " Baby is inside the isolette";
//					System.out.println(s);
//					
//				}
//				else {
//					s = " Baby is not inside the isolette";
//					System.out.println(s);
//				}
//				
				
				
				}
				
			}
			
			catch (InputMismatchException a) {
				System.out.println(a + " Boolean only accepted ");
				
			}
		}
		}	
		


	}
		
		


