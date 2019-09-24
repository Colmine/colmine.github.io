#ifndef Boulder_Engine
#define Boulder_Engine

#include "GLFW/glfw3.h" 
#pragma comment(lib, "opengl32.lib")

#include <iostream>
using namespace std;

class Engine
{
public:
	static int Screen_Width;
	static int Screen_Height;
	static double GetDT();

	Engine();
	~Engine();

	bool Initialize(char* windowTitle);

	void Update();
	void BeginRender();
	void EndRender();

private:
	static GLFWwindow* window;

	static double dt;
	double lastTime;
};

#endif
