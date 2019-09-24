#ifndef Boulder_Texture
#define Boulder_Texture

#include "GLFW/glfw3.h"
#include "SOIL/build/native/include/soil.h"

#include <iostream>
#include <string>
using namespace std;

class Texture
{
public:
	Texture();
	Texture(int _id);
	Texture(string path);

	int GetID();
	int GetWidth();
	int GetHeight();

private:
	bool GetTextureParams();


	int id;
	int width;
	int height;
};

#endif