package practice_package;

public class Second {
public static void main(String[] args) {
	int a[] = {1,2,5,0,8,3,0,2,-2};
	int fm = a[0];
	int sm = a[0];
	for (int i = 0; i < a.length; i++) {
		if(fm>a[i]) {
			if(a[i]!=fm) {
				sm=fm;
			}
			fm = a[i];

			
		}else if(fm==sm || sm>a[i]){
			sm=a[i];
		}
		
	}
	System.out.println(fm+" "+sm);}}