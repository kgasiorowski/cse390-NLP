#include <string>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <vector>

#include "language_modeler.h"
#include "io.h"
#define VER

using namespace std;

int main(){

	string filename = "input.txt";
	cout << "Enter filename: ";
	cin >> filename;
	
	ifstream file;
	file.open(filename.c_str(), ios::in);

	if(file == NULL)
	{

		cerr << "File not found" << endl;
		return 1;
	
	}

	vector<string>* sentences = sentenceTokenizer(file);
	vector<string>* words;
	vector<string> wordlist;

	file.close();

	unsigned int numSentences = 0;
	unsigned int numWords = 0;

	for(unsigned int i = 0; i < sentences->size(); i++){

		string sentence = (*sentences)[i];
		
		#ifdef VERB
		cout << "Sentence: <" << sentence << ">" << endl;
		#endif
		
		numSentences++;
		
		words = wordTokenizer(sentence);
		
		#ifdef VERB
		cout << "Words:";
		#endif
		
		for(unsigned int j = 0; j < words->size(); j++)
		{	
		
			#ifdef VERB
			cout << (*words)[j] << "::";
			#endif
			
			wordlist.push_back((*words)[j]);
			
			numWords++;
		
		}
		
		#ifdef VERB
		cout << endl << endl;
		#endif
		
		delete words;

	} 

	cout << "Number of sentences: " << numSentences << endl;
	cout << "Number of words: " << numWords << endl;

	UnigramMap *map = computeUnigrams(wordlist);

	string outname = "lm/unigram.lm";
	ofstream out;
	out.open((char*)outname.c_str(), ios::out);

	for(auto const unig : *map){

		out << unig.second->word << " " << unig.second->frequency << endl;

	}
	
	#ifdef VERB
	cout << "Freeing memory..." << endl;
	#endif
	
	//Release memory
	for(UnigramMap::iterator it = map->begin();it != map->end(); ++it){
	
		delete it->second;

	}
	delete map;
	
	return 0;	

}
