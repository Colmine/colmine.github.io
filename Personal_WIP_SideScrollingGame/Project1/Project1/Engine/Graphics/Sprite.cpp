#include "Sprite.h"
#include "../Engine.h"
//Sprite properties, only contains open source spaceship sprite right now.
Sprite::Sprite()
{
	xPos = 0;
	yPos = 0;
	rot = 0;
	speed = 100;
	texture = Texture();
}

Sprite::Sprite(string imagePath)
{
	texture = Texture(imagePath);
	xPos = 0;
	yPos = 0;
	rot = 0;
}

Sprite::Sprite(string imagePath, float _xPos, float _yPos)
{
	texture = Texture(imagePath);
	xPos = _xPos;
	yPos = _yPos;
	speed = 100;
	rot = 0;
}

void Sprite::Update()
{

}

void Sprite::Render()
{
	glEnable(GL_TEXTURE_2D);
	glBindTexture(GL_TEXTURE_2D, texture.GetID());
	glLoadIdentity();

	//Translate -> Rotate -> Scale
	glTranslatef(xPos, yPos, 0);
	glRotatef(rot, 0, 0, 1);
	glScalef(xScale, yScale, 1);

	//Rendering
	glColor4f(1, 1, 1, 1);
	glBegin(GL_QUADS);
	glTexCoord2f(0, 0);		glVertex2f(0, 0);
	glTexCoord2f(1, 0);		glVertex2f(texture.GetWidth(), 0);
	glTexCoord2f(1, 1);		glVertex2f(texture.GetWidth(), texture.GetHeight());
	glTexCoord2f(0, 1);		glVertex2f(0, texture.GetHeight());
	glEnd();

	glDisable(GL_PROXY_TEXTURE_2D);
}

void Sprite::SpeedTo(float x)
{
	speed = x;
}

void Sprite::SpeedBy(float x)
{
	speed += x;
}

void Sprite::MoveTo(float x, float y)
{
	xPos = x;
	yPos = y;
}

void Sprite::MoveBy(float x, float y)
{
	xPos += x * Engine::GetDT();
	yPos += y * Engine::GetDT();
}

void Sprite::MoveLeft()
{
	xPos -= speed * Engine::GetDT();
}
void Sprite::MoveRight()
{
	xPos += speed * Engine::GetDT();
}
void Sprite::MoveDown()
{
	yPos -= speed * Engine::GetDT();
}
void Sprite::MoveUp()
{
	yPos += speed * Engine::GetDT();
}

void Sprite::RotateTo(float x)
{
	rot = x;
}

void Sprite::RotateBy(float x)
{
	rot += x * Engine::GetDT();
}

void Sprite::SetScale(float x)
{
	xScale = x;
	yScale = x;
}

void Sprite::SetScale(float x, float y)
{
	xScale = x;
	yScale = y;
}