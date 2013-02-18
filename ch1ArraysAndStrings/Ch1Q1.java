import java.util.HashMap;
import java.util.Arrays;

class Ch1Q1{
	public static void  main(String[] args){
		// question: what happens if there is a space?
		// input lowercases?
		Ch1Q1 c = new Ch1Q1();
		String[] inputs = new String[]{
			"aaaaaaaaabbbbbbbbccccccc",
			"abc",
			"aabc",
			"abca",
			"abac",
			""};
		for(int i=0; i<inputs.length; i++){
			System.out.print("checking " + inputs[i]);
			System.out.print(" hashMethod: " + c.hashMethod(inputs[i]));
			System.out.print(" simpleHash: " + c.simpleHashMapMethod(inputs[i]));
			System.out.print(" constantSpaceMethod: " + c.constantSpaceMethod(inputs[i]));
			System.out.print(" sortMethod: " + c.sortMethod(inputs[i]));
			System.out.print(" compareMethod: " + c.compareMethod(inputs[i]));
			
			System.out.println();
		}
	}
	public boolean hashMethod(String input){
		if(input == null) return true;
		HashMap<Character, Boolean> hash = new HashMap<Character, Boolean>();
		for(int i=0; i<input.length(); i++){
			Character c = input.charAt(i);
			if(hash.containsKey(c)){
				hash.put(c, false);
				return false;
			}else{
				hash.put(c, true);
			}
		}
		return true;
	}
	public boolean simpleHashMapMethod(String input){
		if(input == null) return true;
		boolean hash[] = new boolean[26];
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) <= 'z' && input.charAt(i) >= 'a'){
				if(hash[input.charAt(i) - 'a'] == false){
					hash[input.charAt(i) - 'a'] = true;
				}else{
					return false;
				}
			}
		}
		return true;
	}
	public boolean constantSpaceMethod(String input){
		if(input == null) return true;
		int temp = 0;
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) <= 'z' && input.charAt(i) >= 'a'){
				if( (temp & (1 << (input.charAt(i)-'a'))) > 0 ){
					return false;
				}else{
					temp = temp | (1 << (input.charAt(i) - 'a'));
				}
			}
		}
		return true;
	}
	public boolean sortMethod(String input){
		// no extra space, in placed sort, => quick sort
		char arr[] = input.toCharArray();
		Arrays.sort(arr);
		for(int i=0; i<arr.length-1; i++){
			if(arr[i] == arr[i+1]) return false;
		}
		return true;
	}
	public boolean compareMethod(String input){
		for(int i=0; i<input.length(); i++){
			for(int j=i+1; j<input.length(); j++){
				if(input.charAt(i) == input.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
}
