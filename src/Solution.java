import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	public int[] twoSum(int[] nums,int target){

		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target)
				{
					int a[]= {i,j};
					return a;
				}
			}
		}
		
		return null;	
	}
	
	    public static int lengthOfLongestSubstring(String s) {
	        int maxLength=0;
	        int cur_length=0;
	        int startInd=0;
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i=0;i<s.length();i++){
	        	if(map.containsKey((int)s.charAt(i))&& map.get((int)s.charAt(i))>=startInd){
	        		
	        		cur_length -=map.get((int)s.charAt(i))-startInd;
	        		startInd=map.get((int)s.charAt(i))+1;
	        		map.remove((int)s.charAt(i));
	        		map.put((int)s.charAt(i), i);
	        	}
	        	else
	        	{
	        		map.put((int) s.charAt(i), i);
	        		cur_length++;
	        		if (cur_length>maxLength){
	        			maxLength= cur_length;
	        		}
	        	}
	        }
	        
	        
	        return maxLength;
	    }
	    
	    public static int reverse(int x) {
	        String str = String.valueOf( Math.abs(x));
	        String newStr="";
	        for(int i=str.length()-1;i>=0;i--){
	        	newStr=newStr+str.charAt(i);
	        }
	        if(x!=Math.abs(x))
	        	newStr="-"+newStr;
	        
	        try{
	        return Integer.parseInt(newStr);
	        }catch(Exception e)
	        {
	        	return 0;
	        }
	    }
	    
	    public static boolean isPalindrome(int x) {
	        int r,sum=0,temp;    
	        temp=x;    
	        while(x>0){    
	         r=x%10;  //getting remainder  
	         sum=(sum*10)+r;    
	         x=x/10;    
	        }    
	        if(temp==sum)    
	        	return true;
	        return false;
	    }
	    public static class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
		}

	    public static boolean isBalanced(TreeNode root) {
	    	if(root!=null)
	    		if(Math.abs(maxLength(root.left)-maxLength(root.right))>1) 
	    			return false;
	    	
		    	else{
		    		return isBalanced(root.left)&isBalanced(root.right);
		    	}
	    	return true;
	    	
	    }
	    public static int maxLength(TreeNode root){
	    	if(root==null)
	    		return 0;
	    	return Math.max(maxLength(root.left), maxLength(root.right))+1;
	    }
	    static List<String> list=new ArrayList<String>();  
	    public static List<String> binaryTreePaths(TreeNode root) {
	    	if (root!=null){
	    		getPath(root,"");
	    		return list;
	    	}
	    	return list;
	    }
	    public static void getPath(TreeNode root,String path){
	    	if(root.left!=null)
	    		getPath(root.left,path+root.val+"->");
	    	if(root.right!=null)
	    		getPath(root.right,path+root.val+"->");
	    	if(root.right==null && root.left==null)
	    		list.add(list.size(), path+root.val);
	    }

	    public static class DirLevel{
	    	String str;
	    	int level;
	    	int totalStrLength;
	    	String TotalPath;
	    	DirLevel(String input,int lvl,int totalLen,String totPath){
	    		this.str=input;
	    		this.level=lvl;
	    		this.totalStrLength=totalLen;
	    		this.TotalPath = totPath;
	    	}
	    }
	    public static int lengthLongestPath(String input) {
	    	if (input=="")
	    		return 0;
	        Stack<DirLevel> st=new Stack<DirLevel>();
	    	int maxFilePath=0;
	    	DirLevel prevDir;
	    	int lastLineInd= 0;
    		st.push(new DirLevel("",-1,-1,""));
	    	while(input.length()!=0){
	    		lastLineInd= input.indexOf("\n");
	    		if(lastLineInd==-1)
	    			lastLineInd = input.length();
	    		String str = input.substring(0,lastLineInd);
	    		if(lastLineInd<input.length())
	    			input = input.substring(lastLineInd+1);
	    		else
	    			input = input.substring(lastLineInd);
	    		int currlevel = (str.lastIndexOf("\t")+1);
	    		str=str.replace("\t", "");
	    		prevDir = st.pop();
    			st.push(prevDir);
	    		if((currlevel>prevDir.level)&&(str.indexOf(".")<0)){
	    			st.push(new DirLevel("\\"+str,currlevel,prevDir.totalStrLength+str.length()+1,prevDir.TotalPath+"\\"+str));
	    		}
	    		else if ((currlevel>prevDir.level)&&(str.indexOf(".")>0)){
	    			if(prevDir.totalStrLength+str.length()+1>maxFilePath){
	    				maxFilePath = prevDir.totalStrLength+str.length()+1;
	    				//MaxFilelngthStr = prevDir.TotalPath+"\\"+str;
	    			}
	    		}
	    		else{
	    			prevDir = st.pop();
	    			while((prevDir.level>=currlevel)&&(!st.isEmpty())){
	    				prevDir = st.pop();
	    			}
	    			st.push(prevDir);
	    			if(str.indexOf(".")==-1){	    				
		    				st.push(new DirLevel("\\"+str,currlevel,prevDir.totalStrLength+str.length()+1,prevDir.TotalPath+"\\"+str));
		    		}
	    			else{
	    				if(prevDir.totalStrLength+str.length()+1>maxFilePath)
	    					maxFilePath = prevDir.totalStrLength+str.length()+1;	    					
	    			}
	    		}	    			
	    	}	    	
	    	return maxFilePath;
	    }    
        
        class NumMatrix{
	        public NumMatrix(int[][] matrix) {
	            
	        }
	        
	        public void update(int row, int col, int val) {
	            
	        }
	        
	        public int sumRegion(int row1, int col1, int row2, int col2) {
	            
	        	return 0;
	        }
        }
        static class resClass{
        	int res;
        	boolean add;
        }
        public static int longestConsecutive(TreeNode root) {
        	if(root==null) return 0;
        	int leftRes=longestConsecutive(root.left);
        	leftRes= ((root.left!=null)||(root.val+1==root.left.val))? leftRes+1:leftRes;
        	int rightRes=longestConsecutive(root.right);
        	rightRes=((root.right!=null)||(root.val+1==root.right.val))?  rightRes+1:rightRes;
            return Math.max(leftRes, rightRes);
        	
        	
        	
        	//resClass resC= getlongestConsecutive(root);
            //return resC.res;//((resC.add==true)&&((root.right==null)||(root.val+1==root.right.val)))?resC.res+1:resC.res;
        }
        private static resClass getlongestConsecutive(TreeNode root){
        	resClass resclass= new resClass();
        	if(root==null){
        		resclass.res=0;
        		resclass.add=true;
        		return resclass;
        	}
        	resClass leftResclass=getlongestConsecutive(root.left);
        	resClass rightResclass=getlongestConsecutive(root.right);
        	resclass.res=Math.max(((leftResclass.add==true)&&((root.left==null)||(root.val+1==root.left.val)))?leftResclass.res+1:leftResclass.res,
        			((rightResclass.add==true)&&((root.right==null)||(root.val+1==root.right.val)))?rightResclass.res+1:rightResclass.res);
        	resclass.add = ((rightResclass.add==true)&&((root.right==null)||(root.val+1==root.right.val)))?true:true;
        	return resclass;
        }
        
        public static String addStrings(String num1, String num2) {
            String res="";
            char[] num1arr= num1.toCharArray();
            char[] num2arr= num2.toCharArray();
            int i=num1arr.length-1;
            int j=num2arr.length-1;
            int car=0;
            while(i>=0&&j>=0){
                  int x=num1arr[i--]+num2arr[j--]+car-'0'-'0';
                  res =Integer.toString((x% 10))+res;
                  if(x>9)
                         car=1;
                  else
                         car=0;
            }
            while(i>=0){
                  int x=num1arr[i--]+car-'0';
                  res =Integer.toString(x%10)+res;
                  if(x>9)
                         car=1;
                  else
                         car=0;
            }
            while(j>=0){
                  int x=num2arr[j--]+car-'0';
                  res =Integer.toString(x%10)+res;
                  if(x>9)
                         car=1;
                  else
                         car=0;
            }
            if(car==1)
                  res=1+res;
            return res;
        }     
     
        public static int lengthOfLongestSubstringKDistinct(String s, int k) {
            int[] count = new int[256];
            int num = 0, i = 0, res = 0;
            for (int j = 0; j < s.length(); j++) {
                if (count[s.charAt(j)]++ == 0) num++;
                if (num > k) {
                    while (--count[s.charAt(i++)] > 0);
                    num--;
                }
                res = Math.max(res, j - i + 1);
            }
            return res;
        }
     
        public static int hammingDistance(int x, int y) {
            int diff = x^y;
            int res=Integer.bitCount(diff);
            
            
            
            
            return res;
        }
        
        public static boolean judgeCircle(String moves) {
        	char[] count = new char[26];
            for (char ch : moves.toCharArray()) {
                count[ch-'A']++;
            }
            return count['U'-'A'] == count['D'-'A'] && count['R'-'A'] == count['L'-'A'];
        }
        
        public static int arrayPairSum(int[] nums) {
            int res=0;
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i+=2){
            	res+=nums[i];
            }
            
            return res;
        }
        /*
        public static int depthSum(List<NestedInteger> nestedList) {
        	return helper(nestedList, 1);
        }

        private static int helper(List<NestedInteger> list, int depth)
        {
            int ret = 0;
            for (NestedInteger e: list)
            {
                ret += e.isInteger()? e.getInteger() * depth: helper(e.getList(), depth + 1);
            }
            return ret;
        }*/
        
        public static int findComplement(int num) {
            return num^(Integer.highestOneBit(num)*2-1);
        }
        public static String[] findWords(String[] words) {
        	List<String> x = Arrays.asList(words);
        	return x.stream().filter(w->w.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new );
            //return Stream.of(words).filter(s->s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new );
        }
        
        class Logger {

        	HashMap<String, Integer> messages = new HashMap<>();
            /** Initialize your data structure here. */
            public Logger() {
                
            }
            
            /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
                If this method returns false, the message will not be printed.
                The timestamp is in seconds granularity. */
            public boolean shouldPrintMessage(int timestamp, String message) {
            	Integer time = messages.get(message);
            	if(time!=null){
            		if(timestamp-time<10)
            			return false;
            		else
            			messages.replace(message, time, timestamp);
            	}
            	messages.put(message, timestamp);
            	return true;
                
            }
        }
        
        public static String reverseWords(String s) {
        	String[] strArr = s.split(" ");
        	s="";
        	for(int i =0;i<strArr.length;i++){
        		StringBuilder sb = new StringBuilder(strArr[i]);
        		strArr[i]=sb.reverse().toString();
        	}
        	List<String> sl = Arrays.asList(strArr);
        	return sl.stream().collect(Collectors.joining(" "));
        }
        public static int distributeCandies(int[] candies) {
            HashMap<Integer, Integer> candlesHash=new HashMap<>();
            for(int cand:candies)
            {
            	candlesHash.put(cand, 1);
            	
            }
            
            return Math.min(candies.length/2, candlesHash.size());
        	
        }
        
        static class MovingAverage {

            /** Initialize your data structure here. */
        	List<Integer> list=new ArrayList<Integer>();
        	int pos=0;
        	int size=0;
        	double itemCount=0;
            public MovingAverage(int size) {
                this.size=size;
            }
            
            public double next(int val) {
            	if (pos>=size)
            		list.set(pos%size, val);
            	else
            		list.add(pos%size, val);
            	pos++;
            	itemCount=Math.min(++itemCount, size);
            	double MovAvg = list.stream().reduce(0, Integer::sum)/itemCount;
                return MovAvg;
            }
        }
        
        public static List<String> fizzBuzz(int n) {
            String[] arrList = new String[n];
            for(int i=1;i<=n;i++){
            	arrList[i]=((i%3==0)&&(i%5==0))?"FizzBuzz":
            					(i%3==0)?"Fizz":(i%5==0)?"Buzz":Integer.toString(i);
            }
        	List<String> list= Arrays.asList(arrList);
            return list;
        }
        
        public static int singleNonDuplicate(int[] nums) {
            int res=0;
            for(int i=0;i<nums.length;i++){
            	res=res^nums[i];
            }
            
            return res;
        }
        
        public static int[] countBits(int num) {
            int[] res = new int[num+1];
            res[0]=0;
            int temp=1;
            while(temp<=num){
            	
            	int i=0;
            	while((i<temp) &&(i+temp<=num)){
            		res[i+temp]=res[i++]+1;
            	}
            	temp<<=1;
            }
            
            return res;
        }
        
        public static boolean canPermutePalindrome(String s) {
            char[] ch=s.toCharArray();
            HashMap<Integer, Integer> chExist= new HashMap<Integer,Integer>();
            for(int i=0;i<ch.length;i++){
            	if(chExist.containsKey((Integer)((int)ch[i]))){
            		chExist.remove((Integer)((int)ch[i]));
            	}
            	else
            		chExist.put((Integer)((int)ch[i]), 1);
            }
            if(chExist.size()<=1)
            	return true;
            return false;
        }
        
        static double[][] levelDes = new double[3000][2];
        static int maxLvl=0;
        public static List<Double> averageOfLevels(TreeNode root) {
           TraverseTree(root,0);
           Double[] levelAvg = new Double[maxLvl+1];
           int i=0;
           while(levelDes[i][1]!=0){
                  levelAvg[i]=levelDes[i][0]/levelDes[i++][1];
           }
          
           List<Double> list= Arrays.asList(levelAvg);
            return list;
        }
       
        public static void TraverseTree(TreeNode root,int level){
           if(root==null)
                  return;
           if(level>maxLvl)
                  maxLvl = level;
           levelDes[level][0]+=root.val;
           levelDes[level][1]++;
           TraverseTree(root.left, level+1);
           TraverseTree(root.right, level+1);
        }
        
        public static List<String> generatePossibleNextMoves(String s) {
            List<String> list = new ArrayList<String>();
            int i= s.indexOf("++");
            while(i>=0){
                   list.add(s.replaceFirst("\\+\\+", "--").replace("a", "+"));
                   int oldI=0;
                   i=s.indexOf("++",i+1);
                   while(oldI<i){
                          s=s.replaceFirst("\\+", "a");
                          oldI = s.indexOf("+");
                   }
            }
           
            return list;
         }
        public static boolean isValid(String s) {
            char[] arr = s.toCharArray();
		    Stack<Character> st = new Stack<>();
		    for(int i=0;i<arr.length;i++)
		    {
		            if(arr[i]=='('||arr[i]=='{'||arr[i]=='[')
		                            st.add(arr[i]);
		            else if (!st.empty()){
		                            char ch = st.pop().charValue();
		                            if(((arr[i]==')' &&(ch!='(')))||((arr[i]=='}' &&(ch!='{')))||((arr[i]==']' &&(ch!='['))))
		                                            return false;
		            }
		            else{
		                            return false;
		            }
		    }
		    if(st.empty())
		            return true;
		    return false;
		}
		
		public static int longestConsecutive(int[] nums) {
		    int res=0;
		    HashMap<Integer, Integer> num= new HashMap<>();
		    if (nums.length>0){
		            num.put(nums[0], 1);
		            res = 1;
		    }
		    for(int i=1;i<nums.length;i++){
		            if(!num.containsKey(nums[i])){
		                            int temp=0,left =0,right =0;
		                            if(num.containsKey(nums[i]-1))
		                            left +=  num.get(nums[i]-1);
		                            if(num.containsKey(nums[i]+1))
		                            right +=  num.get(nums[i]+1);
		                           
		                            temp=  left+right+1;
		                            num.put(nums[i], temp);
		                            num.replace(nums[i]-left, temp);
		                            num.replace(nums[i]+right, temp);
		                            if(temp>res)
		                                            res = temp;
		            }
		    }
		    return res;
		}
		public static int minSubArrayLen(int s, int[] nums) {
		    int len=Integer.MAX_VALUE,minLen=Integer.MAX_VALUE;
		    int start =0,sum=0;
		    if (nums.length==0)
		            return 0;
		    for(int i=0;i<nums.length;i++){
		            sum+=nums[i];
		                            while(sum-nums[start]>=s){
		                                            sum -= nums[start];
		                                            start ++;
		                            }
		                            if(sum >= s)
		                            {             
		                                            len = i-start+1;
		                            }
		            minLen= Math.min(len, minLen);
		    }
		    return minLen==Integer.MAX_VALUE?0:minLen;
		}
		public static int search(int[] nums, int target) {
		
		            if (nums.length==0)
		                            return -1;
		            int ind=(nums.length-1)/2;
		            int start =0,end = nums.length-1;
		            while(target!=nums[ind]){
		                            int firstNum = nums[start],lastNum = nums[end];
		            if(target==firstNum) return start;
		            if(target==lastNum) return end;
		           
		                            ind = (start+end)/2;
		                            if((ind ==0)||(ind==end))
		                                            return -1;
		                           
		                            if(((target>nums[ind])&&(target>lastNum)&&(nums[ind]>lastNum))||((target<nums[ind])&&(target<lastNum)&&(nums[ind]>lastNum))||((target>nums[ind])&&(target<lastNum)&&(nums[ind]<lastNum))){
		                                            start = ind+1;
		                            }
		                            else
		                                            end = ind-1;
		                           
		                            ind = (start+end)/2;
		                           
		            }
		            return ind;
		   
		}
		
		HashMap<Integer,ArrayList<Integer>> h = new HashMap<>();
		public Solution(int[] nums) {
		    for(int i=0;i<nums.length;i++){
		            ArrayList<Integer>  arr = h.get(nums[i]);
		            if(arr ==null){
		                            arr= new ArrayList<>();
		                            arr.add(i);
		                            h.put(nums[i], arr);
		            }
		            else
		            {
		                            arr.add(i);
		                            h.replace(nums[i], arr);
		            }
		    }
		}
		public int pick(int target) {
		            ArrayList<Integer>  arr= h.get(target);
		            int x = (int)(Math.random()*arr.size());
		            return arr.get(x);
		}
		
		public class Interval {
		                  int start;
		                  int end;
		                  Interval() { start = 0; end = 0; }
		                  Interval(int s, int e) { start = s; end = e; }
		}
		public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		    ArrayList<Interval> l= new ArrayList<Interval>();
		    int newStart=-1;
		    int newEnd;
		    boolean added = false;
		    for(Interval intrv : intervals){
	           
	            if(((newStart==-1)&&(intrv.end<newInterval.start))||(added)){//start and end after the new interval
	                            l.add(intrv);
	                            newStart=-1;
	            }
	            else if((newStart==-1)&&(intrv.start>newInterval.start)&&(intrv.start>newInterval.end)){//start and end before the new interval
	                            l.add(newInterval);
	                            l.add(intrv);
	                            newStart=-1;
	                            added = true;
	            }
	            else if((newStart==-1)&&(intrv.start<newInterval.start)&&(intrv.end>newInterval.end)){//exist in the interval
	                            l.add(intrv);
	                            newStart=-1;
	                            added = true;
	            }
	            else if((intrv.start>=newInterval.start)&&(newStart==-1)){//start after the new interval
                    newStart = newInterval.start;
                  	if (intrv.end>=newInterval.end)//end after the new interval
                    {                                                   
                        l.add(new Interval(newStart,intrv.end));
                        added = true;
                        newStart=-1;
                    }                             
	            }
	            else if((intrv.start<newInterval.start)&&(newStart==-1)){//start before new interval
	                            newStart = intrv.start;
	                                  
	            }
	            else if (newStart!=-1){
	                            if(intrv.start>newInterval.end){
	                                            l.add(new Interval(newStart,newInterval.end));
	                                            l.add(intrv);
	                                                            newStart=-1;
	                                                            added = true;
	                            }
	                            else if(intrv.end>=newInterval.end){
	                                            l.add(new Interval(newStart,intrv.end));
	                                                            newStart=-1;
	                                                            added = true;
	                            }
	                           
	            }
		    }
		    if(newStart!=-1)
		    {
		            l.add(new Interval(newStart,newInterval.end));
		            added = true;
		    }
		    if(!added)
		            l.add(newInterval);
		    return l;
		}
     
		public static int threeSumSmaller(int[] nums, int target) {
			int res=0;
			Arrays.sort(nums);
			int i=0,j=1,k=2;
			int lastMove = 0;
			if(nums.length<3)
				return 0;
			while(i<nums.length-2){
				if(nums[i]+nums[j]+nums[k]<target)
				{
					res++;
					if(k<nums.length-1)
					{
						k++;
						lastMove = 2;
					}
					else if (j<k-1)
					{
						j++;
						k=j+1;
						lastMove= 1;
					}
					else if(i<j-1)
					{
						i++;
						j=i+1;
						k=j+1;
						lastMove=0;
					}
					else
						break;
				}
				else{
					if(lastMove==0)
						break;
					else if(lastMove==1){
						
						i++;
						j=i+1;
						k=j+1;
						if(i>nums.length-2)
							break;
						lastMove=0;
					}
					else if(lastMove==2){
						
						j++;
						k=j+1;
						lastMove=1;
						if(j>nums.length-1){
							j--;
							i++;
							if(i==j)
								break;
							lastMove=0;
						}
					}
				}
			}
			
			return res;
	    }
		public static String licenseKeyFormatting(String s, int k) {
			StringBuilder sb = new StringBuilder();
	        for (int i = s.length() - 1; i >= 0; i--)
	            if (s.charAt(i) != '-')
	                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
	        return sb.reverse().toString().toUpperCase();
	    }
		
		public boolean isMatch(String s, String p) {
			return s.matches(p.replace("*", ".*"));   
	    }

}
