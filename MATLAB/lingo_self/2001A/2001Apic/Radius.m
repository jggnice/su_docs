clear;clc;
jieguo = zeros(100,4);
for k = 2:2
    t = strcat(int2str(k),'name.bmp');
    I=imread(t);
    thresh = graythresh(I);     %�Զ�ȷ����ֵ����ֵ��
    I2 = im2bw(I,thresh);       %��ͼ���Զ���ֵ�����ɡ�
    J0 = ~(I2);
end
lk = edge(J0,'sobel');
gj = bwmorph(J0,'skel',inf);
imwrite(lk,'sample.bmp','bmp');
[x0,y0,v0] = find(lk);
[a0,b0,c0] = find(gj);
m = length(a0);
n = length(x0);

