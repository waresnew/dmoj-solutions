# Square
square_side = int(input())
s=square_side ** 2

# Rectangle
rect_width = int(input())
rect_length = int(input())
r= rect_width * rect_length

# Triangle
tri_base = int(input())
tri_height = int(input())
t= tri_base * tri_height / 2

print("The area of the square is "+ str(s))
print("The area of the rectangle is "+ str(r))
print("The area of the triangle is "+str(t))
print("The sum of all areas is "+ str(s+r+t))