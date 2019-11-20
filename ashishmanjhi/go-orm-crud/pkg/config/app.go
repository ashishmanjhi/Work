package config

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

var (
	db *gorm.DB
)

// Connect to mysql
func Connect() {
	d, err := gorm.Open("mysql", "root:root@/test1?charset=utf8&parseTime=True&loc=Local")
	if err != nil {
		panic(err)
	}
	db = d
}

// GetDB
func GetDB() *gorm.DB {
	return db
}
