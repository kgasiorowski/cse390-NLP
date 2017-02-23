#include <string>
#include <iostream>
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

	cout << "Word count: " << wordlist.size() << endl;

	return 0;	

}
