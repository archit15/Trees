package com.tree;

import java.util.HashMap;

public class Trie {

	TrieNode root;
	
	public Trie()
	{
		root=new TrieNode((char)0);
	}
	public void insert(String word)
	{
		int length = word.length();        
        TrieNode crawl = root;
           
        // Traverse through all characters of given word
        for( int level = 0; level < length; level++)
        {
            HashMap<Character,TrieNode> child = crawl.getChildren();            
            char ch = word.charAt(level);
            if(child.containsKey(ch))
            	crawl=child.get(ch);
            else
            {
            	TrieNode temp=new TrieNode(ch);
            	child.put(ch, temp);
            	crawl=temp;
            }
            
        }
        crawl.setbIsEnd(true);
	}
	
	public int search(String word)
	{
		int length = word.length();        
        TrieNode crawl = root;
        for( int level = 0; level < length; level++)
        {
        	char ch = word.charAt(level);
        	HashMap<Character,TrieNode> child = crawl.getChildren();
        	if(child.containsKey(ch)==false)
        		return 0;
        	
        }
        return (crawl.getValue());
	}
	
	 public String getMatchingPrefix(String input)  {
	        String result = ""; // Initialize resultant string
	        int length = input.length();  // Find length of the input string       
	           
	        // Initialize reference to traverse through Trie
	        TrieNode crawl = root;
	        int level, prevMatch = 0; 
	        for(level = 0; level < length; level++)
	        {
	        	char ch=input.charAt(level);
	        	HashMap<Character, TrieNode> child=crawl.getChildren();
	        	if(child.containsKey(ch))
	        	{
	        		result+=ch;
	        		crawl=child.get(ch);
	        		if( crawl.isbIsEnd() ) 
	                    prevMatch = level + 1;
	        	}
	        	else break;
	        }
	        
	        if( !crawl.isbIsEnd() )
                return result.substring(0, prevMatch);        
         
        else return result;
			 
	        
	        
	        
	 }
}
