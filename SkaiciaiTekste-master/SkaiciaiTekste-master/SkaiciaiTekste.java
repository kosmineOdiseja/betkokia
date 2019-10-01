import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedWriter;
// import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList; 


public class SkaiciaiTekste {
	
	public static boolean priklausoAibei ( String simbolis, String[] aibe ) {
		
		boolean priklauso = false;
		
		for (int i = 0; i < aibe.length; i++ ) {
		
			if ( simbolis.equals ( aibe [ i ] ) ) {
			
				priklauso = true;
			}
		}
		return priklauso;
	}
		
	public static void main(String[] args) throws Exception {
	   
		String thisLine = null;
		
		String[] skaitmenys = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] dalys_skaiciaus = { ".", ",", "-", "e", "E", "+", "/", "%" };
		String[] zodzio_pabaigos = { ".", ",", " ", "\n", ";", ":" };
		String[] ne_zodzio_dalis = { ")", ",", ";", "." , "/" };
		
		// pagal -------------> https://www.geeksforgeeks.org/java-util-arraylist-indexof-java/
		ArrayList<String> vnt = new ArrayList<String>(1000) ;
		ArrayList<String> anti_vnt = new ArrayList<String>(1000) ;
		
		try {
																									// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader( new FileReader( "tekstas.txt" ) );
			BufferedReader in_kb = new BufferedReader( new InputStreamReader ( System.in ) );
			
			BufferedReader vnt_file = new BufferedReader ( new FileReader ( "vnt.csv" ) );
			
			while ( ( thisLine = vnt_file.readLine() ) != null ) {
				
				if ( ! thisLine.trim().equals ( "" ) ) {
				
					vnt.add( thisLine );
				}
			}
			vnt_file.close();
			
			BufferedReader anti_vnt_file = new BufferedReader ( new FileReader ( "anti_vnt.csv" ) );
			
			while ( ( thisLine = anti_vnt_file.readLine() ) != null ) {
				
				if ( ! thisLine.trim().equals ( "" ) ) {
				
					anti_vnt.add( thisLine );
				}
			}
			anti_vnt_file.close();
			
			System.out.println ( "duomenų failo turinys:" );
			
			String simb;
			String[] skaiciai = new String [ 1000 ];
			String[] vnt_po_skaiciu = new String [ 1000 ];
																									// double[] skaiciai = new double[1000];
			int kiekis_skaiciu = 0; 

			while ( ( thisLine = br.readLine() ) != null ) {
			 
				boolean pries_tai_buvo_skaitmuo = false;
				
				boolean yra_zodis_po_skaitmens = false;
				// boolean yra_zodzio_pradzia_po_skaitmens = false;				
				
				System.out.println( thisLine );
				
				for ( int i = 0; i < thisLine.length(); i++ ) {
					
					simb =  thisLine.substring( i, i+1 );
				
					if ( 
							priklausoAibei ( simb, skaitmenys ) 
						|| 
							( 
									pries_tai_buvo_skaitmuo  
								&& 
									priklausoAibei ( simb, dalys_skaiciaus )
							) 
						||
							yra_zodis_po_skaitmens
					) {
						
						if ( pries_tai_buvo_skaitmuo || yra_zodis_po_skaitmens ) { 				//  ------
							
							if ( yra_zodis_po_skaitmens ) {
								
								vnt_po_skaiciu [ kiekis_skaiciu - 1 ] += simb;  
								
							} else {
						
								skaiciai [ kiekis_skaiciu - 1 ] += simb;
							}
							
						} else {
							
							skaiciai [ kiekis_skaiciu ] = simb;
							vnt_po_skaiciu [ kiekis_skaiciu ] = "";
							kiekis_skaiciu++;
						}
						
						if ( ! yra_zodis_po_skaitmens ) {
							
							pries_tai_buvo_skaitmuo = true;
							
						} else {
						
							if ( priklausoAibei ( simb, zodzio_pabaigos ) ) {
								
								yra_zodis_po_skaitmens = false;
							}
						}
						
					} else {
						
						if ( pries_tai_buvo_skaitmuo ) {
							
							if ( ! priklausoAibei ( simb, ne_zodzio_dalis ) ) {
						
								yra_zodis_po_skaitmens = true;
								// skaiciai [ kiekis_skaiciu - 1 ] += simb;
								vnt_po_skaiciu [ kiekis_skaiciu - 1 ] += simb;
							}
						}
						pries_tai_buvo_skaitmuo = false;
					}
				}
			} 
			System.out.println ( "viso skaiciu: " + kiekis_skaiciu );
			
			for ( int i = 0; i < kiekis_skaiciu; i++ ) {
				
				System.out.println ( " " + skaiciai [ i ] + " " + vnt_po_skaiciu [ i ] );
				
				if ( 
						( vnt.indexOf ( vnt_po_skaiciu [ i ].trim() )  == -1 ) 
					&&  
						(  ! vnt_po_skaiciu [ i ].trim().equals( "" ) ) 
					&&
						( anti_vnt.indexOf ( vnt_po_skaiciu [ i ].trim() ) == -1 )
				) {
				
					System.out.println ( "įtraukti į mat. vnt.? " );
					String ats = in_kb.readLine();
					
					if ( ats.equals( "" ) ) {
						
						vnt.add ( vnt_po_skaiciu [ i ].trim() );
						
					} else {
					
						anti_vnt.add ( vnt_po_skaiciu [ i ].trim() );
					}
				}
			}
			
			System.out.println();
			
			for ( String value : vnt ) { 
				
				System.out.print( value ); 
				System.out.print( " " ); 
			}
			
			try ( 
				BufferedWriter bw = new BufferedWriter( new FileWriter("vnt.csv") );
			) {

				for ( String value : vnt ) { 
							
					bw.write ( value + "\n");
				}
				bw.close();
					
			} catch ( Exception e ) {
				
				System.err.format ( "IOException: %s%n", e );
			}			
				

			try ( 
				BufferedWriter bw = new BufferedWriter( new FileWriter("anti_vnt.csv") );
			) {

				for ( String value : anti_vnt ) { 
							
					bw.write ( value + "\n");
				}
				bw.close();
					
			} catch ( Exception e ) {
				
				System.err.format ( "IOException: %s%n", e );
			}			
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}