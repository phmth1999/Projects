/***CONSTANT */
const COLS = 10;
const ROWS = 20;
const BLOCK_SIZE = 30;
const COLOR_MAPPING =[
    'red',
    'orange',
    'green',
    'purple',
    'blue',
    'cyan',
    'yellow',
    'white',
];

const BRICK_LAYOUT = [
    [
      [
        [1, 7, 7],
        [1, 1, 1],
        [7, 7, 7],
      ],
      [
        [7, 1, 1],
        [7, 1, 7],
        [7, 1, 7],
      ],
      [
        [7, 7, 7],
        [1, 1, 1],
        [7, 7, 1],
      ],
      [
        [7, 1, 7],
        [7, 1, 7],
        [1, 1, 7],
      ],
    ],
    [
      [
        [7, 1, 7],
        [7, 1, 7],
        [7, 1, 1],
      ],
      [
        [7, 7, 7],
        [1, 1, 1],
        [1, 7, 7],
      ],
      [
        [1, 1, 7],
        [7, 1, 7],
        [7, 1, 7],
      ],
      [
        [7, 7, 1],
        [1, 1, 1],
        [7, 7, 7],
      ],
    ],
    [
      [
        [1, 7, 7],
        [1, 1, 7],
        [7, 1, 7],
      ],
      [
        [7, 1, 1],
        [1, 1, 7],
        [7, 7, 7],
      ],
      [
        [7, 1, 7],
        [7, 1, 1],
        [7, 7, 1],
      ],
      [
        [7, 7, 7],
        [7, 1, 1],
        [1, 1, 7],
      ],
    ],
    [
      [
        [7, 1, 7],
        [1, 1, 7],
        [1, 7, 7],
      ],
      [
        [1, 1, 7],
        [7, 1, 1],
        [7, 7, 7],
      ],
      [
        [7, 7, 1],
        [7, 1, 1],
        [7, 1, 7],
      ],
      [
        [7, 7, 7],
        [1, 1, 7],
        [7, 1, 1],
      ],
    ],
    [
      [
        [7, 7, 7, 7],
        [1, 1, 1, 1],
        [7, 7, 7, 7],
        [7, 7, 7, 7],
      ],
      [
        [7, 7, 1, 7],
        [7, 7, 1, 7],
        [7, 7, 1, 7],
        [7, 7, 1, 7],
      ],
      [
        [7, 7, 7, 7],
        [7, 7, 7, 7],
        [1, 1, 1, 1],
        [7, 7, 7, 7],
      ],
      [
        [7, 1, 7, 7],
        [7, 1, 7, 7],
        [7, 1, 7, 7],
        [7, 1, 7, 7],
      ],
    ],
    [
      [
        [7, 7, 7, 7],
        [7, 1, 1, 7],
        [7, 1, 1, 7],
        [7, 7, 7, 7],
      ],
      [
        [7, 7, 7, 7],
        [7, 1, 1, 7],
        [7, 1, 1, 7],
        [7, 7, 7, 7],
      ],
      [
        [7, 7, 7, 7],
        [7, 1, 1, 7],
        [7, 1, 1, 7],
        [7, 7, 7, 7],
      ],
      [
        [7, 7, 7, 7],
        [7, 1, 1, 7],
        [7, 1, 1, 7],
        [7, 7, 7, 7],
      ],
    ],
    [
      [
        [7, 1, 7],
        [1, 1, 1],
        [7, 7, 7],
      ],
      [
        [7, 1, 7],
        [7, 1, 1],
        [7, 1, 7],
      ],
      [
        [7, 7, 7],
        [1, 1, 1],
        [7, 1, 7],
      ],
      [
        [7, 1, 7],
        [1, 1, 7],
        [7, 1, 7],
      ],
    ],
  ];

const KEY_CODES = {
    LEFT: 'ArrowLeft',
    RIGHT: 'ArrowRight',
    UP: 'ArrowUp',
    DOWN: 'ArrowDown',
};

const WHITE_COLOR_ID = 7;

const canvas = document.getElementById('board');
const ctx = canvas.getContext('2d');

ctx.canvas.width = COLS * BLOCK_SIZE;
ctx.canvas.height = ROWS * BLOCK_SIZE;

class Board {
    constructor(ctx) {
        this.ctx = ctx;
        this.grid = this.generateWhiteBoard();
        this.score = 0;
        this.gameOver = false;
        this.isPlaying = false;
    
        this.clearAudio = new Audio('../sound/clear.wav');
      }
      reset() {
        this.score = 0;
        this.grid = this.generateWhiteBoard();
        this.gameOver = false;
        this.drawBoard();
      }
    //tạo khung bảng có 20 hàng, mỗi hàng 10 cột
    generateWhiteBoard() {
        return Array.from({ length: ROWS }, () => Array(COLS).fill(WHITE_COLOR_ID));
    }
    //vẽ ô vuông
    drawCell(xAxis, yAxis, colorId) {
        //set màu cho ô
        this.ctx.fillStyle = COLOR_MAPPING[colorId] || COLOR_MAPPING[WHITE_COLOR_ID];
        //tạo hình vuông cho ô
        this.ctx.fillRect(xAxis * BLOCK_SIZE, yAxis * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        //set màu viền của ô
        this.ctx.fillStyle = 'black';
        //tạo viền cho ô
        this.ctx.strokeRect(xAxis * BLOCK_SIZE, yAxis * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
    }
    //vẽ bảng
    drawBoard() {
        //20 hàng
        for (let row = 0; row < this.grid.length; row++) {
          //10 cột
          for (let col = 0; col < this.grid[0].length; col++) {
            //vẽ ô vuông
            this.drawCell(col, row, this.grid[row][col]);
          }
        }
    }
    //xử lý hàng đã hoàn thành
    handleCompleteRows() {
        const latestGrid = board.grid.filter((row) => { // row => []
            return row.some(col => col === WHITE_COLOR_ID);
          });
      
          const newScore = ROWS - latestGrid.length; // => newScore = tong cong hang da hoan thanh
          const newRows = Array.from({ length: newScore }, () => Array(COLS).fill(WHITE_COLOR_ID));

          if (newScore) {
            board.grid = [...newRows, ...latestGrid];
            this.handleScore(newScore * 10);
      
            this.clearAudio.play();
          }
    }
    //xử lý điểm
    handleScore(newScore) {
        this.score+= newScore;
        document.getElementById('score').innerHTML = this.score;
    }
    //xử lý thua
    handleGameOver() {
        this.gameOver = true;
        this.isPlaying = false;
        alert('GAME OVER!!!');
    }
}
//các khối xếp hình
class Brick {
    //id để set màu
    constructor(id) {
        this.id = id;
        //các khối hình có sẵn
        this.layout = BRICK_LAYOUT[id];
        //hướng của khối hình
        this.activeIndex = 0;
        //vị trí cột của khối hình với bảng
        this.colPos = 0;
        //vị trí hàng của khối hình với bảng
        this.rowPos = -2;
    }
    //vẽ khối hình
    draw() {
        //3 hàng
        for (let row = 0; row < this.layout[this.activeIndex].length; row++) {
          //3 cột
          for (let col = 0; col < this.layout[this.activeIndex][0].length; col++) {
            //chỉ vẽ ô khác màu trắng
            if (this.layout[this.activeIndex][row][col] !== WHITE_COLOR_ID) {
              //hàng cộng rowPos và cột cộng colPos để set vị trí khối hình với bảng
              board.drawCell(col + this.colPos, row + this.rowPos, this.id);
            }
          }
        }
    }
    //vẽ lại khối hình với màu trắng
    clear() {
        for (let row = 0; row < this.layout[this.activeIndex].length; row++) {
          for (let col = 0; col < this.layout[this.activeIndex][0].length; col++) {
            if (this.layout[this.activeIndex][row][col] !== WHITE_COLOR_ID) {
              board.drawCell(col + this.colPos, row + this.rowPos, WHITE_COLOR_ID);
            }
          }
        }
    }
    //di chuyển khối hình sang trái
    moveLeft() {
        if (!this.checkCollision(this.rowPos, this.colPos - 1, this.layout[this.activeIndex])){
            //vẽ lại khối hình màu trắng
            this.clear();
            //vị trí cột của khối hình với bảng trừ đi 1
            this.colPos--;
            //vẽ lại hình đã clear
        this.draw();
        }
    }
    //di chuyển khối hình sang phải
    moveRight() {
        if (!this.checkCollision(this.rowPos, this.colPos + 1, this.layout[this.activeIndex])){
            //vẽ lại khối hình màu trắng
            this.clear();
            //vị trí cột của khối hình với bảng cộng đi 1
            this.colPos++;
            //vẽ lại hình đã clear
        this.draw();
        }
    }
    //di chuyển khối hình xuống dưới
    moveDown() {
        if (!this.checkCollision(this.rowPos + 1, this.colPos, this.layout[this.activeIndex])){
            //vẽ lại khối hình màu trắng
            this.clear();
            //vị trí hàng của khối hình với bảng cộng đi 1
            this.rowPos++;
            //vẽ lại hình đã clear
            this.draw();
            return;
        }
        this.handleLanded();
        generateNewBrick();
    }
    //xoay vòng khối hình
    rotate() {
        if (!this.checkCollision(this.rowPos, this.colPos, this.layout[(this.activeIndex + 1) % 4])){
            this.clear();
            //set lại hướng di chuyển của khối hình
            this.activeIndex = (this.activeIndex + 1) % 4;
            /**
             * activeindex = 0
             * 0 + 1 = 1 % 4 ==> 1
             *
             * activeIndex = 3
             * 3 + 1 = 4 % 4 ==> 0
             *
             * **/
            this.draw();
        }
    }
    //kiểm tra khi di chuyển thoát khỏi bảng
    checkCollision(nextRow, nextCol, nextLayout) {
        // if (nextCol < 0) return true;
        //3 hàng
        for (let row = 0; row < nextLayout.length; row++) {
          //3 cột
          for (let col = 0; col < nextLayout[0].length; col++) {
            if (nextLayout[row][col] !== WHITE_COLOR_ID && nextRow >= 0) {
              //các điều kiện
              //1.giá trị cột khối hình + nextCol < 0 
              //2.giá trị cột khối hình >= cột max của bảng
              //3.giá trị hàng khối hình >= hàng max của bảng
              //4.khối hình va chạm khối hình khác màu trắng
              if (col + nextCol < 0 || col + nextCol >= COLS || row + nextRow >= ROWS || board.grid[row+nextRow][col+nextCol] !== WHITE_COLOR_ID)
              //dừng
              return true;
            }
          }
        }
        return false;
      }
      //xử lý va chạm
      handleLanded() {
        if (this.rowPos <= 0) {
          board.handleGameOver();
          return;
        }
    
        for (let row = 0; row < this.layout[this.activeIndex].length; row++) {
          for (let col = 0; col < this.layout[this.activeIndex][0].length; col++) {
            if (this.layout[this.activeIndex][row][col] !== WHITE_COLOR_ID) {
              board.grid[row + this.rowPos][col + this.colPos] = this.id;
            }
          }
        }
        
        board.handleCompleteRows();
        board.drawBoard();
    }
}

//tạo khối hình ngẫu nhiên
function generateNewBrick() {
    // tao ra 1 id bat ki nam tu 0 -> 6
    brick = new Brick(Math.floor(Math.random() * 10) % BRICK_LAYOUT.length); 
}

//click nút play
document.getElementById('play').addEventListener('click', () => {
    board.reset();
  
    board.isPlaying = true;
    
    generateNewBrick();
  
    const refresh = setInterval(() => {
      if (!board.gameOver) {
        brick.moveDown();
      } else {
        clearInterval(refresh);
      }
    }, 1000);
  })

//hành động di chuyển sang trái, phải, xuống, xoay
document.addEventListener('keydown', (e) => {
    if (!board.gameOver && board.isPlaying) {
      switch (e.code) {
        case KEY_CODES.LEFT:
          brick.moveLeft();
          break;
        case KEY_CODES.RIGHT:
          brick.moveRight();
          break;
        case KEY_CODES.DOWN:
          brick.moveDown();
          break;
        case KEY_CODES.UP:
          brick.rotate();
          break;
        default:
          break;
      }
    }
   
  });

  board = new Board(ctx);
  board.drawBoard();