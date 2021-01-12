$(document).ready(function () {

    $("#collapse").click(function () {
        var collapse = $("#collapse");

        if ($("#collapse").hasClass("move-left")) {
            $("#collapse").removeClass("move-left");
        } else {
            $("#collapse").addClass("move-left");
        }

        if ($(".menu").hasClass("check-close")) {
            $(".menu").animate({
                width: '195px'
            })

            $(".menu").removeClass("check-close");
        } else {
            $(".menu").animate({
                width: '50px'
            })

            $(".menu").addClass("check-close");
        }

        $(".name-menu").animate({
            width: 'toggle'
        })
    });

    $(".li-dad").hover(function () {
        $(".li-son").css("display", "block");
    }, function () {
        $(".li-son").css("display", "none");
    });

    $('.name-menu').on('click', function () {
        var $this = $(this),
            $bc = $('<div class="item"></div>');
        $this.parents('li').each(function (index, li) {
            var $a = $(li).children('a').clone();
            $bc.prepend(' / ', $a);
        });
        $('.breadcrumb').html($bc.prepend('<a >Home</a>'));
        return false;
    })

    $(".add").click(function () {
        if ($(".table-view").hasClass("check-hide")) {
            $(".add-product").hide();
            $(".table-view").show();
            $(".table-view").removeClass("check-hide");
        } else {
            $(".add-product").show();
            $(".table-view").hide();
            $(".table-view").addClass("check-hide");
        }
    })

    $(".icon-menu-category").click(function () {
        $(".add").hide();
        $(".add-product").hide();
        $(".table-view").hide();
        $(".table-view-category").show();
    })

    $(".icon-menu-product").click(function () {
        $(".add").show();
        $(".table-view").show();
        $(".table-view-category").hide();
    })

    $(".button-add-material").click(function () {
        // Clone material item
        var materialItem = $("#materialTemp").clone();

        // Remove class hidden from material item
        materialItem.removeClass("hidden");

        // Show material item into container
        $(".materialContainer").append(materialItem);
    })

})

function deleteMaterial(thisMaterial) {
        $(thisMaterial).parent().remove();
}


function setMenuHeightBelongToDocument() {
    var documentHeight = $(document).height();
    $(".menu").css({"height": documentHeight + 'px'});
}

function windowClick() {
    console.log($(document).height());
    var menu = document.querySelector(".menu");
    menu.style.height = 0 + "px";
    menu.style.height = ($(document).height() - 50) + "px";
}

function addActiveClass(selected) {
    var iconMenu = document.querySelectorAll(".icon-and-menu");
    for (i = 0; i < iconMenu.length; i++) {
        if (i == selected) {
            iconMenu[i].classList.add("active");
        } else {
            iconMenu[i].classList.remove("active");
        }
    }
}

