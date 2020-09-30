import java.util.Iterator;

public class TJDriver {

	public static void main(String[] args) throws Exception {
		
		TechJob AiEng = new TechJob("AI Engineer", 344, 146085);
		TechJob AiEng1 = new TechJob("aI Engineer", 344, 146085);
		TechJob ISA = new TechJob("Information Security Analyst", 32, 98350);
		TechJob SoftEng = new TechJob("Software Engineer", 21, 105590);
		
		TechJob CompRes = new TechJob("Computer Research Scientist", 16, 118370);
		TechJob DA = new TechJob("Data Analyst", 16, 118370);
		TechJob ITManag = new TechJob("IT Manager", 11, 142530);
		TechJob DataAdmin = new TechJob("Database Administrator", 9, 90070);
		
		TechJob CNA = new TechJob("Computer Network Architect", 5, 109020);
		
		
		//TechJob method tests
//		System.out.print(AiEng.toString());				//toString
//		System.out.println(AiEng.equals(AiEng1));		//equals true
//		System.out.println(AiEng.equals(SoftEng));		//equals false
//		System.out.println(AiEng.compareTo(SoftEng));	//should be < 0
		
		
		TJCollection jobs1 = new TJCollection(10);
		jobs1.insert(AiEng);
		jobs1.insert(AiEng1);
		jobs1.insert(ISA);
		jobs1.insert(SoftEng);
		
		jobs1.insert(DA);
		jobs1.insert(CompRes);
		jobs1.insert(ITManag);
		
		
		System.out.println(jobs1.toString());
		
		//TJCollection method tests
//		System.out.println("true : " + jobs1.insert(DataAdmin));
//		System.out.println("8 : " + jobs1.size());
//		System.out.print("aI Engineer : " + jobs1.find("AI Engineer").toString());
//		
//		System.out.println("2 : " + jobs1.countOccurrences("AI Engineer")); 
//		System.out.println("true : " + jobs1.contains(AiEng));
//		System.out.println("false : " + jobs1.contains(CNA));
//		
//		System.out.println("793 : " + jobs1.total());
//		System.out.println("1 : " + jobs1.countRange(20, 30));
		jobs1.delete(AiEng1);
//		System.out.println("7 : " + jobs1.size());
		
		System.out.println(jobs1.toString());
		
//		TJCollection jobs2 = new TJCollection(4);
//		jobs2.insert(DA);
//		jobs2.insert(CompRes);
//		jobs2.insert(ITManag);
//		jobs2.insert(DataAdmin);
		
		System.out.println("--------------------------------"
				+ "-------------------------------------\n");
		
		Iterator<TechJob> iter = jobs1.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next().toString());
		}
		

	}

}


//https://careerkarma.com/blog/best-tech-jobs/