#include <string>
#include <iostream>
#include <fstream>
#include <vector>

#include "io.h"

using namespace std;

int main(){

	string filename = "input.txt";
	cout << "Enter filename: ";
	cin >> filename;
	
	ifstream file;
	file.open(filename.c_str(), ios::in);

	vector<string>* sentences = sentenceTokenizer(file);
	vector<string>* words;

	file.close();

	for(unsigned int i = 0; i < sentences->size(); i++){

		string sentence = (*sentences)[i];
		cout << "Sentence: <" << sentence << ">" << endl;
		
		words = wordTokenizer(sentence);
		cout << "Words:";
		
		for(unsigned int j = 0; j < words->size(); j++)
			cout << (*words)[j] << "::";
		
		cout << endl << endl;
		
		delete words;

	} 

	return 0;	

}
