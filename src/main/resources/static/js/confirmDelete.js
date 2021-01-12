function ConfirmDelete() {
    var x = confirm("Are you sure you want to delete this product?");
    if (x)
        return true;
    else
        return false;
}