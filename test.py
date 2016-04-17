import os
os.environ['DJANGO_SETTINGS_MODULE'] = 'researchdoc.settings'
from searchapp.models import Author
print(Author.objects.all())