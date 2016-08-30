%мЬиообть╣д
i = 0:10;
x = -1+0.2*i;
y = 1./(1+25*x.^2);
p=polyfit(x,y,3);
s=vpa(poly2sym(p))
f = polyval(p,x);
plot( x, f, x, y, 'o ')