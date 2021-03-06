% 大学数学实验  p.156~160|164-168  例7.5     作图p.156|165
% 求解 min 100 ( x2 - x1^2 )^2 + ( 1 - x1 )^2  

[ x, y ] = meshgrid( -2:0.1:2, -1:0.1:3 );
z = 100 * ( y - x.^2 ).^2 + ( 1 - x ).^2;
mesh(x, y, z)
figure(2)
contour( x, y, z, 20)
x0 = [ -1.9, 2 ];
hold on, plot([-1.9, 1], [2, 1],'o')
text([-1.9; 1] + 0.08, [2; 1], ['初始点';'最优点'])
hold off