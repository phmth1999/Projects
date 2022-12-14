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
    //t???o khung b???ng c?? 20 h??ng, m???i h??ng 10 c???t
    generateWhiteBoard() {
        return Array.from({ length: ROWS }, () => Array(COLS).fill(WHITE_COLOR_ID));
    }
    //v??? ?? vu??ng
    drawCell(xAxis, yAxis, colorId) {
        //set m??u cho ??
        this.ctx.fillStyle = COLOR_MAPPING[colorId] || COLOR_MAPPING[WHITE_COLOR_ID];
        //t???o h??nh vu??ng cho ??
        this.ctx.fillRect(xAxis * BLOCK_SIZE, yAxis * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        //set m??u vi???n c???a ??
        this.ctx.fillStyle = 'black';
        //t???o vi???n cho ??
        this.ctx.strokeRect(xAxis * BLOCK_SIZE, yAxis * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
    }
    //v??? b???ng
    drawBoard() {
        //20 h??ng
        for (let row = 0; row < this.grid.length; row++) {
          //10 c???t
          for (let col = 0; col < this.grid[0].length; col++) {
            //v??? ?? vu??ng
            this.drawCell(col, row, this.grid[row][col]);
          }
        }
    }
    //x??? l?? h??ng ???? ho??n th??nh
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
    //x??? l?? ??i???m
    handleScore(newScore) {
        this.score+= newScore;
        document.getElementById('score').innerHTML = this.score;
    }
    //x??? l?? thua
    handleGameOver() {
        this.gameOver = true;
        this.isPlaying = false;
        alert('GAME OVER!!!');
    }
}
//c??c kh???i x???p h??nh
class Brick {
    //id ????? set m??u
    constructor(id) {
        this.id = id;
        //c??c kh???i h??nh c?? s???n
        this.layout = BRICK_LAYOUT[id];
        //h?????ng c???a kh???i h??nh
        this.activeIndex = 0;
        //v??? tr?? c???t c???a kh???i h??nh v???i b???ng
        this.colPos = 0;
        //v??? tr?? h??ng c???a kh???i h??nh v???i b???ng
        this.rowPos = -2;
    }
    //v??? kh???i h??nh
    draw() {
        //3 h??ng
        for (let row = 0; row < this.layout[this.activeIndex].length; row++) {
          //3 c???t
          for (let col = 0; col < this.layout[this.activeIndex][0].length; col++) {
            //ch??? v??? ?? kh??c m??u tr???ng
            if (this.layout[this.activeIndex][row][col] !== WHITE_COLOR_ID) {
              //h??ng c???ng rowPos v?? c???t c???ng colPos ????? set v??? tr?? kh???i h??nh v???i b???ng
              board.drawCell(col + this.colPos, row + this.rowPos, this.id);
            }
          }
        }
    }
    //v??? l???i kh???i h??nh v???i m??u tr???ng
    clear() {
        for (let row = 0; row < this.layout[this.activeIndex].length; row++) {
          for (let col = 0; col < this.layout[this.activeIndex][0].length; col++) {
            if (this.layout[this.activeIndex][row][col] !== WHITE_COLOR_ID) {
              board.drawCell(col + this.colPos, row + this.rowPos, WHITE_COLOR_ID);
            }
          }
        }
    }
    //di chuy???n kh???i h??nh sang tr??i
    moveLeft() {
        if (!this.checkCollision(this.rowPos, this.colPos - 1, this.layout[this.activeIndex])){
            //v??? l???i kh???i h??nh m??u tr???ng
            this.clear();
            //v??? tr?? c???t c???a kh???i h??nh v???i b???ng tr??? ??i 1
            this.colPos--;
            //v??? l???i h??nh ???? clear
        this.draw();
        }
    }
    //di chuy???n kh???i h??nh sang ph???i
    moveRight() {
        if (!this.checkCollision(this.rowPos, this.colPos + 1, this.layout[this.activeIndex])){
            //v??? l???i kh???i h??nh m??u tr???ng
            this.clear();
            //v??? tr?? c???t c???a kh???i h??nh v???i b???ng c???ng ??i 1
            this.colPos++;
            //v??? l???i h??nh ???? clear
        this.draw();
        }
    }
    //di chuy???n kh???i h??nh xu???ng d?????i
    moveDown() {
        if (!this.checkCollision(this.rowPos + 1, this.colPos, this.layout[this.activeIndex])){
            //v??? l???i kh???i h??nh m??u tr???ng
            this.clear();
            //v??? tr?? h??ng c???a kh???i h??nh v???i b???ng c???ng ??i 1
            this.rowPos++;
            //v??? l???i h??nh ???? clear
            this.draw();
            return;
        }
        this.handleLanded();
        generateNewBrick();
    }
    //xoay v??ng kh???i h??nh
    rotate() {
        if (!this.checkCollision(this.rowPos, this.colPos, this.layout[(this.activeIndex + 1) % 4])){
            this.clear();
            //set l???i h?????ng di chuy???n c???a kh???i h??nh
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
    //ki???m tra khi di chuy???n tho??t kh???i b???ng
    checkCollision(nextRow, nextCol, nextLayout) {
        // if (nextCol < 0) return true;
        //3 h??ng
        for (let row = 0; row < nextLayout.length; row++) {
          //3 c???t
          for (let col = 0; col < nextLayout[0].length; col++) {
            if (nextLayout[row][col] !== WHITE_COLOR_ID && nextRow >= 0) {
              //c??c ??i???u ki???n
              //1.gi?? tr??? c???t kh???i h??nh + nextCol < 0 
              //2.gi?? tr??? c???t kh???i h??nh >= c???t max c???a b???ng
              //3.gi?? tr??? h??ng kh???i h??nh >= h??ng max c???a b???ng
              //4.kh???i h??nh va ch???m kh???i h??nh kh??c m??u tr???ng
              if (col + nextCol < 0 || col + nextCol >= COLS || row + nextRow >= ROWS || board.grid[row+nextRow][col+nextCol] !== WHITE_COLOR_ID)
              //d???ng
              return true;
            }
          }
        }
        return false;
      }
      //x??? l?? va ch???m
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

//t???o kh???i h??nh ng???u nhi??n
function generateNewBrick() {
    // tao ra 1 id bat ki nam tu 0 -> 6
    brick = new Brick(Math.floor(Math.random() * 10) % BRICK_LAYOUT.length); 
}

//click n??t play
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

//h??nh ?????ng di chuy???n sang tr??i, ph???i, xu???ng, xoay
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