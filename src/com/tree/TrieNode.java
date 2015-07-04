package com.tree;

import java.util.HashMap;

public class TrieNode {
	private char value;    
    private HashMap<Character,TrieNode> children;
    public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}
	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}
	public boolean isbIsEnd() {
		return bIsEnd;
	}
	public void setbIsEnd(boolean bIsEnd) {
		this.bIsEnd = bIsEnd;
	}
	private boolean bIsEnd; 
	
	public TrieNode(char ch)  {
        value = ch;
        children = new HashMap<>();
        bIsEnd = false;
    }    

}
