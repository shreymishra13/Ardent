
const mongoose = require("mongoose");

const express = require("express");
const ejs = require('ejs');
const bodyParser = require("body-parser");
const bcrypt = require("bcrypt");
const nodemailer = require("nodemailer");
const multer = require("multer");
const app = express();
var fs = require('fs');
var path = require('path');
const saltRounds = 10;
const PORT= process.env.PORT || 5000





//Schema declarations
const customerSchema = new mongoose.Schema({
    customer_name: String,
    customer_email: String,
    customer_mobileNo: Number,
    customer_password: String,
    customer_address: String,
    customer_pincode: Number

});
const sellerSchema = new mongoose.Schema({
    seller_name: String,
    seller_email: String,
    seller_mobileNo: Number,
    seller_password: String,
    seller_address: String,
    seller_pincode: Number

});
const feedbackSchema = new mongoose.Schema({
    reviewer_name: String,
    reviewer_email: String,
    reviewer_mobileNo: Number,
    review: String


});
const booksSchema = new mongoose.Schema({
    book_name: String,
    book_author: String,
    book_type: String,
    book_description: String,
    book_price: Number,
    book_img:
    {
        data: Buffer,
        contentType: String
    }



});
const adminSchema = new mongoose.Schema({
    admin_name: String,
    admin_mobileNo: Number,
    admin_password: String,
    admin_email: String,
    admin_address: String,
    admin_pincode: Number
});

const paymentSchema = mongoose.Schema({
    payer_name: String,
    payer_email: String,
    payment_amount: Number,
    payment_status: Boolean,
    payment_date: Date
});

//Model declarations
const customerModel = new mongoose.model('Customer', customerSchema);
const sellerModel = new mongoose.model('Seller', sellerSchema);
const feedbackModel = new mongoose.model('Feedback', feedbackSchema);
const bookModel = new mongoose.model('Book', booksSchema);
const paymentModel = new mongoose.model('Payment', paymentSchema);
const adminModel = new mongoose.model('admin', adminSchema);

//setting of engines and usage
app.set('view engine', 'ejs');
app.use(express.static("public"));
app.use(bodyParser.urlencoded({
    extended: true

}));

//connecting with the database MONGODB
mongoose.set("strictQuery", true);
mongoose.connect("mongodb+srv://admin-shrey:shrey001@cluster0.kto3pxv.mongodb.net/eBookDB", {

    useNewUrlParser: true,
    useUnifiedTopology: true
}, (err) => {
    if (err) console.log(err);
    else {
        console.log("connected to db");
    }

});

var storage = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, 'uploads')
    },
    filename: (req, file, cb) => {
        cb(null, file.fieldname + '-' + Date.now())
    }
});

var upload = multer({ storage: storage });


//get request handlers
app.get("/", (req, res) => {
    bookModel.find((err, books) => {
        if (err)
            console.log(err);
        else {

            res.render("index", { books });

        }
    });

});
app.get("/about", (req, res) => {
    res.render("about");
});

app.get("/index", (req, res) => {
    bookModel.find((err, books) => {
        if (err)
            console.log(err);
        else {

            res.render("index", { books });

        }
    });
});

app.get("/blog", (req, res) => {
    res.render("blog");
});
app.get("/contact", (req, res) => {
    res.render("contact", { isSubmitted: false });
});

app.get("/work", (req, res) => {
    res.render("work");
});
app.get("/signup", (req, res) => {
    res.render("signup", { status: "1" });

});
app.get("/login", (req, res) => {
    res.render("login", { status: "1" });

});

app.get("/forget-password", (req, res) => {

    res.render("forget-password", { isWrongCredentials: false, isPasswordUpdated: false });

});
app.get("/privacy-policy", (req, res) => {
    res.render("privacy-policy");
});

app.get("/terms-conditions", (req, res) => {
    res.render("./terms-conditions")
});
app.get("/about", (req, res) => {
    res.render("./about");
});
app.get("/reviews", (req, res) => {
    res.render("reviews");

});
app.get("/book", (req, res) => {

    bookModel.find((err, books) => {
        if (err)
            console.log(err);
        else {

            res.render("book", { searchedBookFound: "true", books });

        }
    });
});
app.get("/review", (req, res) => {
    res.render("review", { isSubmitted: false });

});
app.get("/seller-module", (req, res) => {
    res.render("seller-module");
});
app.get("/adding-book", (req, res) => {
    res.render("adding-book", { success: "" });
});
app.get("/refund", (req, res) => {
    res.render("refund");
})
app.get("/deleting-book", (req, res) => {
    res.render("deleting-book", { status: "0" });
});

// post request handlers

app.post("/signup", (req, res) => {

    if (req.body.password === req.body.confirmationPassword) {

        const accountType = req.body.accountType;
        console.log(accountType);
        //add the username already existed to all other module.
        if (accountType === "user") {
            customerModel.findOne({ customer_email: req.body.email }, (err, foundOne) => {
                if (err) console.log(err);
                if (foundOne) {
                    res.render("signup", { status: "2", message: "Username already existed!! Try with another email or " });
                }
                else {
                    bcrypt.hash(req.body.password, saltRounds, function (err, hash) {
                        if (err) console.log(err);
                        const newCustomer = new customerModel({

                            customer_name: req.body.name,
                            customer_email: req.body.email,
                            customer_password: hash,
                            customer_mobileNo: req.body.mobileNo,
                            customer_address: req.body.address,
                            customer_pincode: req.body.pincode

                        });
                        newCustomer.save((err) => {
                            if (err) console.log(err);
                        });
                    });
                    res.render("signup", { status: "3", message: "Account succesfully created. You can login into the account!!" });
                }
            });
        }
        else if (accountType === "seller") {
            bcrypt.hash(req.body.password, saltRounds, function (err, hash) {
                const newSeller = new sellerModel({
                    seller_name: req.body.name,
                    seller_email: req.body.email,
                    seller_password: hash,
                    seller_mobileNo: req.body.mobileNo,
                    seller_address: req.body.address,
                    seller_pincode: req.body.pincode
                });
                newSeller.save((err) => {
                    if (err) console.log(err);
                });
            });
           
            res.render("signup", { status: "3", message: "Account succesfully created. You can login into the account!!" });
        }
        else {
            bcrypt.hash(req.body.password, saltRounds, function (err, hash) {
                const newAdmin = new adminModel({

                    admin_name: req.body.name,
                    admin_password: hash,
                    admin_email: req.body.email,
                    admin_mobileNo: req.body.mobileNo,
                    admin_address: req.body.address,
                    admin_pincode: req.body.pincode
                });
                newAdmin.save((err) => {
                    if (err) console.log(err);
                });
            });
      
            res.render("signup", { status: "3", message: "Account succesfully created. You can login into the account!!" });
        }
    } else {
        res.render("signup", { status: "2", message: "Password doesn't match!!" });
    }
});
app.post("/review", (req, res) => {
    const feedback = new feedbackModel({
        reviewer_name: req.body.name,
        reviewer_email: req.body.email,
        reviewer_mobileNo: req.body.mobileNo,
        review: req.body.feedback
    });
    feedback.save((err) => {
        console.log(err);
    });
    res.render("review", { isSubmitted: true });
});

app.post("/book", (req, res) => {
    const nameOfSearchedBook = req.body.searchedBook;
    if (nameOfSearchedBook === "") res.render("book");
    else {
        books.findOne({ book_name: nameOfSearchedBook }, (err, foundOne) => {
            if (err) console.log(err);
            if (foundOne) { console.log(true); }
            else {
                console.log("false");
            }
        });
    }
});
app.post("/adding-book", (req, res) => {

    const newBook = new bookModel({
        book_name: req.body.bookName,
        book_author: req.body.authorName,
        book_type: req.body.bookType,
        book_description: req.body.bookDescription,
        book_price: req.body.bookPrice,
    });
});
app.post("/login", (req, res) => {
    const email = req.body.email;
    const accountType = req.body.accountType;
    if (accountType === "user") {
        customerModel.findOne({ customer_email: email }, (err, foundOne) => {
            if (err) console.log(err);
            if (foundOne) {
                bcrypt.compare(req.body.passwords, foundOne.customer_password, function (err, result) {
                    // result == true
                    if (result) {
                        res.redirect("index");
                    }
                    else {

                        res.render("login", { status: "2", message: "Incorrect Password!!" });
                    }
                });
            } else {
                res.render("login", { status: "3", message: "Incorrect Username/email!!" });
            }
        });
    }
    else if (accountType === "seller") {
        sellerModel.findOne({ seller_email: email }, (err, foundOne) => {
            if (err) console.log(err);
            if (foundOne) {
                bcrypt.compare(req.body.passwords, foundOne.seller_password, function (err, result) {
                    // result == true
                    if (result) {
                        res.render("seller-module");
                    }
                    else {
                        res.render("login", { status: "2", message: "Incorrect Password!!" });
                    }
                });

            } else {
                res.render("login", { status: "3", message: "Incorrect Username/email!!" });
            }
        });

    }
    else {
        adminModel.findOne({ admin_email: email }, (err, foundOne) => {
            if (err) console.log(err);
            if (foundOne) {
                bcrypt.compare(req.body.passwords, foundOne.admin_password, function (err, result) {
                    // result == true
                    if (result) {
                        res.render("admin-module");
                    }
                    else {
                        res.render("login", { status: "2", message: "Incorrect Password!!" });
                    }
                });

            } else {
                res.render("login", { status: "3", message: "Incorrect Username/email!!" });
            }
        });
    }
});
app.post("/contact", (req, res) => {

    const userFeedback = new feedbackModel({
        reviewer_name: req.body.name,
        reviewer_email: req.body.email,
        reviewer_mobileNo: req.body.mobileNo,
        review: req.body.message
    });

    userFeedback.save((err) => {
        console.log(err);
    });

    res.render("contact", { isSubmitted: true });
});

app.post('/adding-book', upload.single('bookImage'), (req, res, next) => {

    const newBook = new bookModel({
        book_name: req.body.bookName,
        book_author: req.body.authorName,
        book_type: req.body.bookType,
        book_description: req.body.bookDescription,
        book_price: req.body.bookPrice,
        book_img: {
            data: fs.readFileSync(path.join(__dirname + '/uploads/' + req.file.filename)),
            contentType: 'image/png'
        }
    });
    bookModel.create(newBook, (err, item) => {
        if (err) {
            console.log(err);
        }
        else {
            item.save();
            res.render("adding-book", { success: "Voila!! Book added successfully" })
        }
    });
});

app.post("/deleting-book", (req, res) => {

    const bookName = req.body.bookName;
    const authorName = req.body.authorName;
    const genre = req.body.bookType;

    bookModel.findOne({ book_name: bookName, author_name: authorName, book_type: genre }, { book_img: 0 }, (err, foundOne) => {
        if (err) console.log(err);
        if (foundOne) {
            bookModel.deleteOne({ book_name: bookName, author_name: authorName, book_type: genre }, (err) => {
                if (err) console.log(err);
            });
            console.log("deleted successfully");
            res.render("deleting-book", { status: "1", message: "Voila!! Book Deleted Successfully" });
        }
        else {
            //not found
            res.render("deleting-book", { status: "2", message: "Book Not found , Incorrect details!!" });
        }
    });
});
app.post("/book", (req, res) => {
    const nameOfSearchedBook = req.body.searchedBook;
    if (nameOfSearchedBook === "") {
        res.redirect("book");
    }
    else {
        bookModel.find({ book_name: nameOfSearchedBook }, (err, foundOne) => {
            if (err) console.log(err);
            if (foundOne) {

                res.render("book", { books: foundOne, searchedBookFound: "true" });
                console.log("508")
            }
            else {
                res.render("book", { searchedBookFound: "false" });
            }
        });
    }
});
//function that generates a random password when the user forgot the password
function randomPasswordGenerator() {
    var chars = "0123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*()ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    var passwordLength = 12;
    var password = "";
    for (var i = 0; i <= passwordLength; i++) {
        var randomNumber = Math.floor(Math.random() * chars.length);
        password += chars.substring(randomNumber, randomNumber + 1);
    }
    return password;
}
app.post("/forget-password", (req, res) => {
    const email = req.body.email;
    const accountType = req.body.accountType;
    if (accountType === "user") {
        customerModel.findOne({ customer_email: email }, (err, foundOne) => {
            if (foundOne) {
                const pass = randomPasswordGenerator();
                let transporter = nodemailer.createTransport({
                    host: "smtp.ethereal.email",
                    port: 587,
                    secure: false, // true for 465, false for other ports
                    auth: {
                        user: 'gaetano.boehm88@ethereal.email',
                        pass: 'G2evJnE8wYA5V5AVr7' // generated ethereal password
                    },
                });

                // send mail with defined transport object
                let info = transporter.sendMail({
                    from: '"Shrey Mishra 👻" <ardentebooks@ardent.co.in>', // sender address
                    to: "mishra.shrey001@gmail.com", // list of receivers
                    subject: "Random Generated Password for your account", // Subject line
                    text: "The new password for your account is : " + pass, // plain text body
                });

                bcrypt.hash(pass, saltRounds, function (err, hash) {
                    if (err) console.log(err);
                    customerModel.updateOne({ customer_name: foundOne.customer_name }, { customer_password: hash }, (err) => {
                        if (err) console.log(err);
                    });
                });
                res.render("forget-password", { isWrongCredentials: false, isPasswordUpdated: true });
            }
            else {
                res.render("forget-password", { isWrongCredentials: true, isPasswordUpdated: false });
            }
        })
    }
});
// app.listen(PORT, (err) => {
//     if (!err) {
//         console.log("running on server ${PORT}");
//     }
// });
app.listen(3000, (err) => {
    if (!err) {
        console.log("running on server");
    }
});
