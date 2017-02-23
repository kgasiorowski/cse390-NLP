#ifndef IO_H
#define IO_H

#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <iostream>
#include <fstream>

#include "language_modeler.h"

#define MAX_SENTENCE 5000

using namespace std;

string& trim(string&);
vector<string>* wordTokenizer(string);
vector<string>* sentenceTokenizer(ifstream&);
void printUnigrams(UnigramMap*);
void printBigrams(BigramMap*);

#endif
