#ifndef LANG_MOD
#define	LANG_MOD

#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

//Represents a unigram, or a word. Has a string 
struct Unigram{
	
	string word;
	unsigned int frequency;

	Unigram(): frequency(0) {}
	Unigram(string s): word(s) { Unigram(); }
	Unigram(unsigned int f): frequency(f) {}
	Unigram(string s, unsigned int f) : word(s), frequency(f) {}
	Unigram(unsigned int f, string s) : word(s), frequency(f) {}

};
typedef unordered_map<string, Unigram*> UnigramMap;

//Represents a typical bigram. Has two words, and a frequency denoting how often it appears.
struct Bigram{

	string firstword; //This bigram's first occuring word
	UnigramMap* secondwords; //List of words that appear after this word

	Bigram(){
		secondwords = new UnigramMap();
	}

	Bigram(string s){
		secondwords = new UnigramMap();
		firstword = s;
	}

	~Bigram(){

		delete secondwords;

	}

};
typedef unordered_map<string, Bigram*>  BigramMap;

UnigramMap* computeUnigrams(vector<string>);
BigramMap*  computeBigrams(vector<string>);
void insertUnigram(UnigramMap*, string);

#endif
