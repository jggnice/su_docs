clear;clc;
    filename = '3name.png';
    I=imread(filename);
    thresh = graythresh(I);     %自动确定二值化阈值；
    I2 = im2bw(I,thresh);       %对图像自动二值化即可。
    J0 = ~(I2);
lk = edge(J0,'sobel');
imwrite(lk,'sample.bmp','bmp');
[x0,y0,v0] = find(lk);
n = length(x0);
disp(['number of points is '  num2str(n)]);
disp('output txt file is ztq.txt')
disp('output bmp file is sample.bmp');
fp = fopen('ztq.txt','wt');
for i =1 : n-1
    fprintf(fp, '%d,%d,\n', y0(i),x0(i));
end
fprintf(fp, '%d,%d\n', y0(n),x0(n));
fclose(fp);
disp('task finished successfully !');