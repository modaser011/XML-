package FMA_7AGA;
import java.util.Scanner;

import org.w3c.dom.Node;

public class MAIN {     
  static int xx=0;
  
	public static void main(String argv[]) {
		Catalogue catalogue = new Catalogue();
		Printer printer = new Printer();
		Book b1 = new Book(); 

		try (Scanner sc = new Scanner(System.in)) {
			while (true) {

				System.out.println(
           "1. Add More Books \n" + " ___________________________________________\n"
						+ "2. search \n"+ " ___________________________________________\n"+
            "3. search 2 \n" + 
                        
                        " ___________________________________________\n" + "4. Deletet \n"+
						 " ___________________________________________\n" + "5. Display All Books  \n"
						+ " ___________________________________________\n" + "6. Exit \n"
						+" ___________________________________________\n");

				System.out.print("Enter number to do the operation number you want do it: ");
				String choice = sc.nextLine();
				
                            switch (choice) {
                                case "1":
                                    System.out.print("Enter the number of Books: ");
                                    int n = sc.nextInt();
                                    sc.nextLine();
                                    for (int i = 0; i < n; i++) {
                                        System.out.println("Book "+ (i +1) +"\n"
                                                + "___________________________________________");
                                               //System.out.print("Enter id: ");
                                                //String id = sc.nextLine();
                                                //b1.setId(Integer.toString(xx++)+id);
                                                //b1.setId(id);
                                                // we can use any one of them 
                                                b1.setId(Integer.toString(++xx));

                                                System.out.print("Enter author: ");
                                                String author = sc.nextLine();
                                                b1.setAuthor(author); 

                                        System.out.print("Enter title: ");
                                        String title = sc.nextLine();
                                        b1.setTitle(title);;
                                        
                                        System.out.print("Enter genre: ");
                                        String genre = sc.nextLine();
                                        b1.setGenre(genre);

                                        System.out.print("Enter price: ");
                                        String price = sc.nextLine();
                                        b1.setPrice(price);

                                        System.out.print("Enter pdate: ");
                                        String pdate = sc.nextLine();
                                        b1.setPublishDate(pdate);                                
                                        
                                        System.out.print("Enter Description: ");
                                        String disc = sc.nextLine();
                                        b1.setDescription(disc);
                                       
                                        catalogue.addBook(b1);
                                        
                                        System.out.println("**********************************************************\n");
                                    }
                                    break;
                                case "2":
                                    System.out.println("Enter Title OR Author)");
                                    String title = sc.nextLine();
                                    catalogue.searchAll(title);
                                   // if(node == null)
                                     //   System.out.println("Not Found.");
                                    //else
                                      //  printer.printNode(node);
                                    break;
                                    case "3":
                                    System.out.println("Enter Title OR Author)");
                                    String title2 = sc.nextLine();
                                    catalogue.searchAll2(title2);
                                   // if(node == null)
                                     //   System.out.println("Not Found.");
                                    //else
                                      //  printer.printNode(node);
                                    break;
                                    case "4":
                                    System.out.println("Enter ID)");
                                    String id = sc.nextLine();
                                    catalogue.delete(id);
                                   // if(node == null)
                                     //   System.out.println("Not Found.");
                                    //else
                                      //  printer.printNode(node);
                                    break;
                                case "5":
                                printer.printAll(catalogue);
                                break;
                                   case "6":
                                   System.out.println("Thank you ");
                                   return;
                                default:
                                    System.out.println("Invalid Choice");
                                    break;
                            }
				
				System.out.println("\n\n\n");
			}
		}

	}
}
