#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

//Represents a unigram, or a word. Has a string 
struct Unigram{

	string word;
	unsigned int frequency;
	
	Unigram(): frequency(0) {}
	Unigram(string s, int f) : word(s), frequency(f) {}

};

//Represents a typical bigram. Has two words, and a frequency denoting how often it appears.
struct Bigram{

	Unigram *firstWord, *secondWord;
	unsigned int frequency;

	Bigram(): frequency(0) {}
	Bigram(Unigram *fw, Unigram *sw, int f): firstWord(fw), secondWord(sw), frequency(f) {}

};


typedef unordered_map<string, Unigram*> UnigramMap;
typedef unordered_map<string, Bigram*>  BigramMap;

UnigramMap* computeUnigrams(vector<string>);
bool mapContains(UnigramMap, Unigram);

