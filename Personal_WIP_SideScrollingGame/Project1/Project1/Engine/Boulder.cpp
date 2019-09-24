#include "Engine.h"
#include "Graphics/Sprite.h"
#include "IO/Mouse.h"
#include "IO/Keyboard.h"

#include <iostream>
using namespace std;

int main()
{
	cout << "Hi fag." << endl;

	Engine engine;
	engine.Initialize((char*)"Hello");

	Sprite testSprite = Sprite("Assests/Art/Spaceship.png", 0, 0);

	while (true)
	{
		engine.Update();
		testSprite.Update();
		
		//testSprite.SetPos((float)Mouse::GetMouseX(), (float)Mouse::GetMouseY());
		testSprite.SetScale(.4f);

		if (Mouse::ButtonDown(GLFW_MOUSE_BUTTON_LEFT))
		{
			testSprite.RotateBy(240);
		}
		if (Mouse::ButtonUp(GLFW_MOUSE_BUTTON_RIGHT))
		{
			testSprite.RotateBy(-240);
		}
		if (Mouse::Button(GLFW_MOUSE_BUTTON_5))
		{
			testSprite.RotateBy(120);
		}
		if (Mouse::Button(GLFW_MOUSE_BUTTON_4))
		{
			testSprite.RotateBy(-120);
		}
		if (Keyboard::Key(GLFW_KEY_W))
		{
			testSprite.MoveUp();
		}
		if (Keyboard::Key(GLFW_KEY_S))
		{
			testSprite.MoveDown();
		}
		if (Keyboard::Key(GLFW_KEY_A))
		{
			testSprite.MoveLeft();
		}
		if (Keyboard::Key(GLFW_KEY_D))
		{
			testSprite.MoveRight();
		}
		engine.BeginRender();
		testSprite.Render();
		engine.EndRender();
	}
	return 0;
}