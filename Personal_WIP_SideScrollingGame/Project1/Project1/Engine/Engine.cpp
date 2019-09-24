#include "Engine.h"
#include "IO/Mouse.h"
#include "IO/Keyboard.h"

int Engine::Screen_Width = 768;
int Engine::Screen_Height = 1024;
GLFWwindow* Engine::window = NULL;
using namespace std;
double Engine::dt = 0;

Engine::Engine() //TODO
{


}

Engine::~Engine() //TODO
{


}

bool Engine::Initialize(char* windowTitle) //Engine initalization
{
	if (!glfwInit())
	{
		cout << "Error initializing GLFW." << endl;
		return false;
	}
	window = glfwCreateWindow(Screen_Width, Screen_Height, windowTitle, NULL, NULL);
	if (window == NULL)
	{
		cout << "Error creating window." << endl;
		return false;
	}
	//OpenGL
	glfwMakeContextCurrent(window);
	int width, height;
	glfwGetFramebufferSize(window, &width, &height);
	glfwSwapInterval(1);

	glfwSetCursorPosCallback(window, Mouse::MousePosCallback);
	glfwSetMouseButtonCallback(window, Mouse::MouseButtonCallback);

	glfwSetKeyCallback(window, Keyboard::KeyCallback);

	const GLFWvidmode* mode = glfwGetVideoMode(glfwGetPrimaryMonitor());
	int xPos = (mode->width - Screen_Width) / 2;
	int yPos = (mode->height - Screen_Height) / 2;
	glfwSetWindowPos(window, xPos, yPos);

	//GL
	//Viewport
	glViewport(0, 0, width, height);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(0, width, 0, height, -10, 10);
	glDepthRange(-10, 10);
	glMatrixMode(GL_MODELVIEW);
	
	//Alpha Blending
	glEnable(GL_ALPHA_TEST);
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

	lastTime = glfwGetTime();

	return true;
}

void Engine::Update()
{
	double now = glfwGetTime();
	dt = (now - lastTime);
	lastTime = now;
	glfwPollEvents();
}

void Engine::BeginRender()
{
	glClearColor(0, 1, 0, 1);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
}

void Engine::EndRender()
{
	glfwSwapBuffers(window);

}

double Engine::GetDT()
{
	return dt;
}